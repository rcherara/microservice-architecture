import React, { useState } from 'react';
import { Button, Fade, Spinner } from 'reactstrap';

const FadeGithub = (props) => {
    const [fadeIn, setFadeIn] = useState(false);

    const toggle = () => setFadeIn(!fadeIn);

    return (
        <div>
            <Button color="primary" onClick={toggle}>GitHub</Button>
            <Fade in={fadeIn} tag="h5" className="mt-3">
                <Spinner size="sm" color="primary" />{' '} GitHub : https://github.com/rcherara/
                <br></br>
                <Spinner size="sm" color="warning" /> Source : "https://github.com/rcherara/building-a-microservice-architecture/"
            </Fade>
        </div>
    );
}

export default FadeGithub;