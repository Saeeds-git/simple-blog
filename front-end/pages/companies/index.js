import { useEffect, useState } from 'react';

import Head from 'next/head';
import { Fragment } from 'react';

import AllPosts from '../../components/posts/all-posts';
// import { getAllPosts } from '../../lib/posts-util';

function AllPostsPage(props) {

  const [postsArrey, setpostsArrey] = useState(props.postsArrey);
  const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
    setIsLoading(true);
    fetch('http://localhost:8080/company')
      .then((response) => response.json())
      .then((data) => {
        // console.log(data);
        setpostsArrey(data);
        setIsLoading(false);
      });
  }, []);

  if (isLoading) {
    return <p>Loading ...</p>
  }

  if (!postsArrey) {
    <p>No Data ...</p>
  }


  return (
    <Fragment>
      <Head>
        <title>All Posts</title>
        <meta
          name='description'
          content='این صفحه شامل لیست تمام شرکت های فعال در مرکز رشد میباشد.'
        />
      </Head>
      <AllPosts posts={postsArrey} />
      {console.log(postsArrey)}
    </Fragment>
  );
}

// export function getStaticProps() {
//   const allPosts = getAllPosts();

//   return {
//     props: {
//       posts: allPosts,
//     },
//   };
// }

export default AllPostsPage;






// import { useEffect, useState } from 'react';
// import useSWR from 'swr';

// function LastSalesPage(props) {
//   const [sales, setSales] = useState(props.sales);
//   // const [isLoading, setIsLoading] = useState(false);

//   const { data, error } = useSWR(
//     'https://nextjs-course-c81cc-default-rtdb.firebaseio.com/sales.json',
//     (url) => fetch(url).then(res => res.json())
//   );

//   useEffect(() => {
//     if (data) {
//       const transformedSales = [];

//       for (const key in data) {
//         transformedSales.push({
//           id: key,
//           username: data[key].username,
//           volume: data[key].volume,
//         });
//       }

//       setSales(transformedSales);
//     }
//   }, [data]);

//   // useEffect(() => {
//   //   setIsLoading(true);
//   //   fetch('https://nextjs-course-c81cc-default-rtdb.firebaseio.com/sales.json')
//   //     .then((response) => response.json())
//   //     .then((data) => {
//   //       const transformedSales = [];

//   //       for (const key in data) {
//   //         transformedSales.push({
//   //           id: key,
//   //           username: data[key].username,
//   //           volume: data[key].volume,
//   //         });
//   //       }

//   //       setSales(transformedSales);
//   //       setIsLoading(false);
//   //     });
//   // }, []);

//   if (error) {
//     return <p>Failed to load.</p>;
//   }

//   if (!data && !sales) {
//     return <p>Loading...</p>;
//   }

//   return (
//     <ul>
//       {sales.map((sale) => (
//         <li key={sale.id}>
//           {sale.username} - ${sale.volume}
//         </li>
//       ))}
//     </ul>
//   );
// }

// export async function getStaticProps() {
//   const response = await fetch(
//     'https://nextjs-course-c81cc-default-rtdb.firebaseio.com/sales.json'
//   );
//   const data = await response.json();

//   const transformedSales = [];

//   for (const key in data) {
//     transformedSales.push({
//       id: key,
//       username: data[key].username,
//       volume: data[key].volume,
//     });
//   }

//   return { props: { sales: transformedSales } };
// }

// export default LastSalesPage;