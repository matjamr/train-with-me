import React, { useCallback, useEffect } from 'react'
import { Button } from '../../components/Welcome/Button'
import { Link, Route, useNavigate } from 'react-router-dom'
import './Login.css';
import { useState } from 'react';
import { useContext } from 'react';
import { UserContext } from '../../context/User/UserContext';
import { loginUser } from '../../context/User/UserActions';

export const Login = () => {
    const [loginShouldBeRendered, setLoginShouldBeRendered] = useState(true);
    const [email, setEmail] = useState("");
    const [firstname, setFirstname] = useState("");
    const [surname, setSurname] = useState("");
    const [password, setPassword] = useState("");
    const [passwordRepeat, setPasswordRepeat] = useState("");
    const [loggedIn, setLoggedIn] = useState("");

    const { user, dispatch } = useContext(UserContext);
    const navigate = useNavigate();
    
  
    const loginBtnHandler = async () => {

        const token = await loginUser(email, password);
        setLoggedIn(true);
        dispatch({type: "LOGIN_USER", payload: {token: token}});
    }

    useEffect(() => {
        console.log(user);
    }, [user]);

    const registerBtnHandler = () => {
        
    }

    const changeStateHandler = () => {
        setLoginShouldBeRendered(!loginShouldBeRendered);
    }

    const renderRegister = () => {
        return <>
            <div className='single-input-area'>
                <label className='label'>Name</label>
                <input type="text" className='input' onChange={(e) => setFirstname(e.target.value)}/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Surname</label>
                <input type="text" className='input' onChange={(e) => setSurname(e.target.value)}/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Email</label>
                <input type="text" className='input' onChange={(e) => setEmail(e.target.value)}/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Password</label>
                <input type="password" className='input' onChange={(e) => setPassword(e.target.value)}/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Repeat</label>
                <input type="password" className='input' onChange={(e) => setPasswordRepeat(e.target.value)}/>
            </div>
        </>
    }

    const renderLogin = () => {
        return <>
            <div className='single-input-area'>
                <label className='label'>Email</label>
                <input type="tWext" className='input' onChange={(e) => setEmail(e.target.value)}/>
            </div>
            <div className='single-input-area'>
                <label className='label'>Password</label>
                <input type="password" className='input' onChange={(e) => setPassword(e.target.value)}/>
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
                        {loginShouldBeRendered 
                            ?(
                            <Button onClick={loginBtnHandler} >
                                Login
                            </Button>
                            ) 
                            :(
                            <Button onClick={registerBtnHandler} >
                                Register
                            </Button>
                        )}
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
