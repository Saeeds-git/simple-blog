import Link from 'next/link';

import Logo from './logo';
import classes from './main-navigation.module.css';

function MainNavigation() {
  return (
    <header className={classes.header}>
      <Link href='/' legacyBehavior>
        <a>
          <Logo />
        </a>
      </Link>
      <nav>
        <ul>
          <li>
            <Link href='/companies'>شرکت ها</Link>
          </li>
          <li>
            <Link href='/opportunities'>موقعیت ها</Link>
          </li>
          <li>
            <Link href='/contact'>ارتباط با ما</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}

export default MainNavigation;
