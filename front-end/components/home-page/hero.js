import Image from 'next/image';

import classes from './hero.module.css';

function Hero() {
  return (
    <section className={classes.hero}>
      <div className={classes.image}>
        <Image
          src='/images/site/main.jpg'
          alt='main motivational image'
          width={300}
          height={300}
        />
      </div>
      <h1>مرکز رشد دانشگاه قم</h1>
      <h3>فضایی برای جذب و توسعه استعداد ها و ظرفیت های دانشجویان</h3>
      <p>
      پارک علم و فناوری دانشگاه قم، زیست بومی برای نوآوری و کارآفرینی است که با تدوین و پیاده سازی زنجیره ارزشی خلق ثروت از صاحبان ایده، افراد با استعداد و بلندهمت، صاحبان کسب وکارهای فناور و دانش بنیان حمایت می کند
      </p>
    </section>
  );
}

export default Hero;
