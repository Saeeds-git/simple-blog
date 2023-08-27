import ReactMarkdown from "react-markdown";
import Image from "next/image";

import PostHeader from "./post-header";
import classes from "./post-content.module.css";

function PostContent(props) {
  if (!props.post) {
    return <p>Loading Data ...</p>;
  }

  const {
    address,
    jobEnum,
    description,
    id,
    name,
    region,
    startYear,
    techStack
  } = props.post;

  return (
    <article className={classes.content}>
      <PostHeader title={name} image={region} />
      <div className={classes.generalData}>
        <p>{description}</p>
        <div >
          <span className={classes.divs}> حوضه مورد نیاز :</span>
          <span className={classes.spans}>{jobEnum}</span>
        </div>
        <div>
          <span  className={classes.divs}> تکنولوژی مورد استفاده : </span>
          <span className={classes.spans}>{techStack}</span>
        </div>
       
      </div>
      {/* <ReactMarkdown renderers={customRenderers}>{post.content}</ReactMarkdown> */}
    </article>
  );
}

export default PostContent;
