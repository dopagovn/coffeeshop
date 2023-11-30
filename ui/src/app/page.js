import Image from 'next/image'
import styles from './page.module.css'
import Button from './_components/Button/page'
import TextField from './_components/TextField/page'
import DatePicker from './_components/DatePicker/page'
import Header from './_components/layouts/Header'
import Body from './_components/layouts/Body'


export default function Home() {
  return (
    <main className={styles.main}>
      <Header />
      Test
      <Body />
    </main>
  )
}
