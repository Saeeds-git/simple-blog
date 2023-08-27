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
    categoryEnum,
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
          <span className={classes.divs}> سال شروع فعالیت :</span>
          <span className={classes.spans}>{startYear}</span>
        </div>
        <div>
          <span  className={classes.divs}> تکنولوژی مورد استفاده : </span>
          <span className={classes.spans}>{techStack}</span>
        </div>
        <div>
          <span className={classes.divs}> آدرش دفتر شرکت :</span>
          <span className={classes.spans}>{address}</span>
        </div>
      </div>
      {/* <ReactMarkdown renderers={customRenderers}>{post.content}</ReactMarkdown> */}
    </article>
  );
}

export default PostContent;
