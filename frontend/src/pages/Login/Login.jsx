import React, { useCallback } from 'react'
import { Button } from '../../components/Welcome/Button'
import { Link } from 'react-router-dom'
import './Login.css';
import { useState } from 'react';

export const Login = () => {
    const [loginShouldBeRendered, setLoginShouldBeRendered] = useState(true);

  
    const loginBtnHandler = () => {
        
    }

    const changeStateHandler = () => {
        setLoginShouldBeRendered(!loginShouldBeRendered);
    }

    const renderRegister = () => {
        return <>
            <div className='single-input-area'>
                <label className='label'>Name</label>
                <input type="text" className='input'/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Surname</label>
                <input type="text" className='input'/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Email</label>
                <input type="text" className='input'/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Password</label>
                <input type="password" className='input'/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Repeat</label>
                <input type="password" className='input'/>
            </div>
        </>
    }

    const renderLogin = () => {
        return <>
            <div className='single-input-area'>
                <label className='label'>Email</label>
                <input type="tWext" className='input'/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Password</label>
                <input type="password" className='input'/>
            </div>
        </>
    }

    return (
        <div className='my-container'>
            <div className='navbar'>
                <div className='navbar-element max-left'>
                    <h2>FuckinUiDotCom</h2>
                </div>
                <div className='body'>

                </div>
            </div>
            <div className='content'>
                <form>
                    {loginShouldBeRendered ? renderLogin() : renderRegister()}
                    
                    <div className='button-area'>
                        <Button onClick={loginBtnHandler} >
                            {loginShouldBeRendered ? 'Login' : 'Register' }
                        </Button>
                        <Button onClick={changeStateHandler}>
                            {loginShouldBeRendered ? 'Does not have account?' : 'Already has an account?' }
                        </Button>
                    </div>
                    {loginShouldBeRendered && 
                        <>
                            <hr className='break-line' />
                            <Link to="/change-password" className='chng-passwd noselect'>
                                Forget password? Click me!
                            </Link>
                        </>
                    }
                </form>
            </div>
        </div>
    )
}
