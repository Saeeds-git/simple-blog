import { useEffect, useState } from "react";

import Head from "next/head";
import { Fragment } from "react";

import AllPosts from "../../components/posts2/all-posts";
// import { getAllPosts } from '../../lib/posts-util';

function AllPostsPage(props) {
  const [postsArrey, setpostsArrey] = useState(props.postsArrey);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    Promise.all([
      fetch("http://localhost:8080/company"),
      fetch("http://localhost:8080/advertisement")
    ])
      .then(([resUsers, resPosts]) =>
        Promise.all([resUsers.json(), resPosts.json()])
      )
      .then(([dataUsers, dataPosts]) => {
        const transferedData = [];

        dataPosts.forEach((key) => {
          dataUsers.forEach((obj) => {
            if (key.companyId == obj.id) {
              key.region = obj.region;
              key.name = obj.name
            }
          });
          transferedData.push(key);
          setpostsArrey(transferedData);
          setIsLoading(false);
        });
      });
  }, []);


  if (isLoading) {
    return <p>Loading ...</p>;
  }

  if (!postsArrey) {
    <p>No Data ...</p>;
  }

  return (
    <Fragment>
      <Head>
        <title>All Posts</title>
        <meta
          name="description"
          content="این صفحه شامل لیست تمام شرکت های فعال در مرکز رشد میباشد."
        />
      </Head>
      <AllPosts posts={postsArrey} />
      {console.log(postsArrey)}
    </Fragment>
  );
}


export default AllPostsPage;
