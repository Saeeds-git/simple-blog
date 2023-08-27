import PostItem from './post-item';
import classes from './posts-grid.module.css';

function PostsGrid(props) {
  const { posts } = props;

  if (!posts) {
    return <p>no data yet ...</p>
  }

  return (
    <ul className={classes.grid}>
      {posts.map((post) => 
  
        <PostItem key={post.id} post={post} />
      
     )}
    </ul>
  );
}

export default PostsGrid;
