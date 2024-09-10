import React from 'react';

const TestPage = () => {
    const handleClick = () => {
        console.log("Button was clicked!");
    };

    return (
        <div style={{ padding: '20px', textAlign: 'center' }}>
            <h1>Hello, this is a test page!</h1>
            <button onClick={handleClick}>Click me!</button>
        </div>
    );
};

export default TestPage;
