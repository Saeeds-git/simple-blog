import Link from "next/link";
import Image from "next/image";

import classes from "./post-item.module.css";

function PostItem(props) {
  // const { title, image, excerpt, date, slug } = props.post;
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

  // const formattedDate = new Date(date).toLocaleDateString('en-US', {
  //   day: 'numeric',
  //   month: 'long',
  //   year: 'numeric',
  // });

  // const imagePath = `/images/posts/${slug}/${image}`;
  // const linkPath = `/posts/${slug}`;

  return (
    <li className={classes.post}>
      

      <Link href={`opportunities/${id}`} legacyBehavior>
        <a>
          <div className={classes.image}>
            <Image
              src={region}
              alt={name}
              width={300}
              height={200}
              layout="responsive"
            />
          </div>
          <div className={classes.content}>
            <h3>{name}</h3>
            {/* <time>{formattedDate}</time>  */}
            <p>{`#${jobEnum}`}</p>
          </div>
        </a>
      </Link>
    </li>
  );
}

export default PostItem;
