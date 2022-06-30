import React, { useState,useEffect } from 'react';
import Dropdown from 'react-bootstrap/Dropdown'
const StudentDropdown = (props) => {
    const  ItemNumbers = {
        Five: 5,
        Ten: 10,
        Twenty_Five: 25
    }

return(
    <Dropdown>
        <Dropdown.Toggle variant="success" id="dropdown-basic">
           How Many Items?
        </Dropdown.Toggle>
        <Dropdown.Menu>
            <Dropdown.Item onClick={() => props.handleAmountPerPage(ItemNumbers.Five)}>5</Dropdown.Item>
            <Dropdown.Item onClick={() => props.handleAmountPerPage(ItemNumbers.Ten)}>10</Dropdown.Item>
            <Dropdown.Item onClick={() => props.handleAmountPerPage(ItemNumbers.Twenty_Five)}>25</Dropdown.Item>
        </Dropdown.Menu>
    </Dropdown>
)
}
export default StudentDropdown;