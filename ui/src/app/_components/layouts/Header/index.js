'use client';

import Link from "next/link";
import styles from './style.module.css';
import Button from "../../Button/page";

const Header = () => {
  return (
    <>
      <header className={styles.header}>
        <div className={styles.home}>
          <img src="/logo.png" width={90} height={90} />
          <Link className={styles.logo} href={''}>LUCKYCOFFEE</Link>
        </div>
        <nav className={styles.nav_menu}>
          <Link className={styles.nav_item} href={''}>Home</Link>
          <Link className={styles.nav_item} href={''}>About</Link>
          <Link className={styles.nav_item} href={''}>Menu</Link>
          <Link className={styles.nav_item} href={''}>Contact Us</Link>
          <Button variant={'contained'} sx={{ width: 140, maxHeight: 50, fontSize: 20 }}>Login</Button>
        </nav>
      </header>
    </>
  )
}

export default Header