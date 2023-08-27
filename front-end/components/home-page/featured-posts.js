import { useEffect, useState } from 'react';

import PostsGrid from '../posts/posts-grid';
import classes from './featured-posts.module.css';

function FeaturedPosts(props) {
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
    <section className={classes.latest}>
      <h2>شرکت های برتر</h2>
      <PostsGrid posts={postsArrey} />
    </section>
  );
}

export default FeaturedPosts;
