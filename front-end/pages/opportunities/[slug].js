import { useEffect, useState } from "react";
import { useRouter } from "next/router";

import Head from "next/head";
import { Fragment } from "react";

import PostContent from "../../components/posts/post-detail/post-content";
import ContactForm from "../../components/jobApply/contact-form";
// import { getPostData, getPostsFiles } from '../../lib/posts-util';

function PostDetailPage(props) {
  const router = useRouter();

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
              key.name = obj.name;
              key.techStack = obj.techStack;
            }
          });
          transferedData.push(key);
          if (key.id == router.query.slug) {
            console.log(key);
            setpostsArrey(key);
            console.log(key);
          }
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
        <title>{postsArrey}</title>
      </Head>
      <PostContent post={postsArrey} />
      {postsArrey ? <ContactForm addId={postsArrey.id} /> : ""}
    </Fragment>
  );
}

export default PostDetailPage;
