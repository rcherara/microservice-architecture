import React, { useState } from 'react';
import { Button, Fade, Tooltip } from 'reactstrap';

const FadeBlogs = (props) => {
    const [fadeIn, setFadeIn] = useState(true);

    const toggle = () => setFadeIn(!fadeIn);

    const [tooltipOpen, setTooltipOpen] = useState(false);

    const toggle2 = () => setTooltipOpen(!tooltipOpen);

    return (
        <div>
            <Button color="primary" onClick={toggle}>Blogs</Button>
            <Fade in={fadeIn} tag="h5" className="mt-3">
                 <p>Cliquez ici pour plus tutorial <span style={{textDecoration: "underline", color:"blue"}} href="#" id="TooltipExample">"https://rcherara.ca/"</span>.</p>

                <Tooltip placement="right" isOpen={tooltipOpen} target="TooltipExample" toggle={toggle2}>
                     My Blogs URL !
                </Tooltip>
                 
            </Fade>
        </div>
    );
}

export default FadeBlogs;