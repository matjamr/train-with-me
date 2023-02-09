import React from 'react'
import {Button} from '../../components/Welcome/Button'
import './Welcome.css'

const Welcome = () => {

    const handleOnLoginRegisterBtnClicked = () => {
        console.log("nigger");
    }

    return (
        <div className='my-container'>
            <div className='navbar'>
                <div className='navbar-element max-left'>
                    <h2>FuckinUiDotCom</h2>
                </div>
                <Button
                    className='navbar-element max-right'
                    onClick={handleOnLoginRegisterBtnClicked}
                >
                    Login / Register
                </Button>
            </div>
            <div className='content'>
                <div className='upper-section'>
                    <div className='img-section'>
                        <img
                            src={require("../../assets/dummy-background.png")}
                            alt="trainer background"
                            width={300}
                        />
                    </div>
                    <div className='title-section' style={{width: '45%'}}>
                        <div className='title-upper-section'>
                            Take training to <br></br>the next level with<br></br> me
                        </div>
                        <hr className='title-breakline'/>
                        <div className='title-lower-section'>
                            or just with my app :)
                        </div>
                        <div className='title-btns-section'>
                            <Button onClick={() => console.log("aaa")} style={{width: '33%'}}>
                                Pricing
                            </Button>
                            <Button onClick={() => console.log("aaa")} style={{width: '33%'}}>
                                About me
                            </Button>
                        </div>
                    </div>
                </div>

            </div>
            <div className='lower-section'>
                <div className='review-section' style={{width: '20%'}}>
                    <div className='top-review-section'>
                        <img
                            src={require("../../assets/dummy-background.png")}
                            alt="" className='profile-img'
                            width={100}
                        />
                        <div className='details'>
                            <div className='stars highlighted details-element'>
                                0/5 ST
                            </div>
                            <div className='experience highlighted details-element'>
                                5 y MU
                            </div>
                        </div>
                    </div>
                    <div className='content-review-section'>
                        <div className='content-text'>
                            Such profesionalism was unexpected
                        </div>
                    </div>
                </div>
                <div className='review-section' style={{width: '45%'}}>
                    <div className='top-review-section'>
                        <img
                            src={require("../../assets/dummy-background.png")}
                            alt="" className='profile-img'
                            width={100}
                        />
                        <div className='details'>
                            <div className='stars highlighted details-element'>
                                ADVANCED
                            </div>
                            <div className='experience highlighted details-element'>
                                CALISTEHNICS
                            </div>
                        </div>
                    </div>
                    <div className='exercise-section-bottom'>
                        <div className='stars highlighted details-element'>
                            ADVANCED
                        </div>
                        <div className='experience highlighted details-element'>
                            CALISTEHNICS
                        </div>
                    </div>
                </div>
            </div>
            <div className='footer'>
                Copyright
            </div>
        </div>
    )
}

export default Welcome
