import React from 'react'
import { Link } from 'react-router-dom'
import { Button } from '../Welcome/Button'

export const Navbar = () => {
  return (
    <div className='navbar'>
        <div className='navbar-element max-left'>
            <h2>FuckinUiDotCom</h2>
        </div>
        <Button
            className='navbar-element max-right'
        >
            <Link to="/login"> 
                Login / Register
            </Link>
        </Button>
    </div>
  )
}
