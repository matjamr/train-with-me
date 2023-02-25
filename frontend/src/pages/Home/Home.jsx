import React from 'react'
import { useContext } from 'react'
import { UserContext } from '../../context/User/UserContext'

const Home = () => {
    const {dispatch, user} = useContext(UserContext);

    console.log(user);

  return (
    <div>
      
    </div>
  )
}

export default Home
