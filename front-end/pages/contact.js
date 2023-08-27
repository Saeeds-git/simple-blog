import { Fragment } from "react";
import Head from "next/head";

import ContactForm from "../components/contact/contact-form";

import social from "../config/social.json";
import Social from "../components/social/Social";

function ContactPage() {
  return (
    <Fragment>
      <Head>
        <title>Contact Me</title>
        <meta name="description" content="Send me your messages!" />
      </Head>
      <div
        style={{
          backgroundColor: "#FFFFFF",
          marginRight: "2rem",
          marginLeft: "2rem",
          height: "20rem",
          fontSize: "1.53rem",
          direction: "rtl",
          borderRadius: "5px",
          padding: "1rem 2rem 1rem 2rem  "
        }}
      >
        <p>
          دانشگاه قم در سال ۹۳ مجوز ایجاد پارک علم و فناوری را از شورای گسترش
          وزارت علوم دریافت نمود و فعالیت پارک با ابلاغ اساس‌نامه آن از سوی
          وزارت عتف در آبان‌ماه ۹۵ آغاز شد. پارک علم و فناوری دانشگاه قم
          همان‌گونه که از آن انتظار می‌­رود و هنگام تأسیس نیز در برنامه کاری و
          چشم­‌انداز بر آن تاکید داشته است، یک “پارک دانشگاهی” است که هدف اصلی
          آن، فراهم کردن شرایط لازم برای توانمند‌سازی و بروز استعداد و شایستگی
          دانشگاهیان است تا بتوانند در جهت ایجاد و پایدارسازی کسب‌و‌کارهای
          فناورانه و ارزش‌آفرینی در راستای حل مسائل جامعه گام بردارند.{" "}
        </p>
        <Social source={social} className="profile-social-icons mt-8" />
      </div>
    </Fragment>
  );
}

export default ContactPage;
