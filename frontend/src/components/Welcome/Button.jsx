import React from 'react';
import PropTypes from 'prop-types';

export const Button = ({onClick, className, children, style}) => {
    return (
        <div style={style} className={`${className} btn-standard noselect`} onClick={onClick}>
            {children}
        </div>
    )
}

Button.propsType = {
    onClick: PropTypes.func.isRequired,
    className: PropTypes.string,
    children: PropTypes.array
}
