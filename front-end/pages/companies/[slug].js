import { useEffect, useState } from "react";
import { useRouter } from "next/router";

import Head from "next/head";
import { Fragment } from "react";

import PostContent from '../../components/posts2/post-detail/post-content';
// import { getPostData, getPostsFiles } from '../../lib/posts-util';

function PostDetailPage(props) {
  const router = useRouter();

  const [postsArrey, setpostsArrey] = useState(props.postsArrey);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    fetch("http://localhost:8080/company")
      .then((response) => response.json())
      .then((data) => {

        data.forEach((key) => {
          if (key.id == router.query.slug) {
            setpostsArrey(key);
          }
        });
        setIsLoading(false);
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
        <title>{postsArrey}</title>
        {/* <meta name='description' content={props.post.excerpt} /> */}
      </Head>
      <PostContent post={postsArrey} />
    </Fragment>
  );
}

// export function getStaticProps(context) {
//   const { params } = context;
//   const { slug } = params;

//   const postData = getPostData(slug);

//   return {
//     props: {
//       post: postData,
//     },
//     revalidate: 600,
//   };
// }

// export function getStaticPaths() {
//   const postFilenames = getPostsFiles();

//   const slugs = postFilenames.map((fileName) => fileName.replace(/\.md$/, ''));

//   return {
//     paths: slugs.map((slug) => ({ params: { slug: slug } })),
//     fallback: false,
//   };
// }

export default PostDetailPage;
