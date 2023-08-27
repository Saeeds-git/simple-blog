import { Fragment } from 'react';
import Head from 'next/head';

import FeaturedPosts from '../components/home-page/featured-posts';
import Hero from '../components/home-page/hero';
// import { getFeaturedPosts } from '../lib/posts-util';
import social from "../config/social.json";
import Social from "../components/social/Social";


function HomePage(props) {
  return (
    <Fragment>
      <Head>
        <title>مرکز رشد</title>
        <meta
          name='description'
          content='I post about programming and web development.'
        />
      </Head>
      <Hero />

      <Social source={social} className="profile-social-icons mt-8" />
      <FeaturedPosts posts={props.posts} />
    </Fragment>
  );
}

// export function getStaticProps() {
//   const featuredPosts = getFeaturedPosts();

//   return {
//     props: {
//       posts: featuredPosts,
//     },
//   };
// }

export default HomePage;
