import React, { useState,useEffect } from 'react';
import axios from 'axios';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Card from 'react-bootstrap/Card';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import {Alert} from "react-bootstrap";

const StudentForm = () => {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [show, setShow] = useState(false);

    const handleSubmit = async(e) => {
        e.preventDefault();
      await  axios.post('http://localhost:8080/api/students/new', {
            firstName: firstName,
            lastName: lastName,
            email: email
        })
        .then(function (response) {
            console.log(response);
            setShow(true);
            setTimeout(() => {
                setShow(false);
            }, 3000);
        })
        .catch(function (error) {
            console.log(error);
        });
    }
    return(
        <Form onSubmit={(e)=>handleSubmit(e)} >
            {show?
                <Container>
                    <Alert variant="success">
                        <Alert.Heading>You are adding {firstName + lastName}!</Alert.Heading>
                        <p>You have sucesfully added a person to the Database. Congrats!</p>
                    </Alert>
                </Container>:null

            }
            <Form.Group controlId="formBasicFirstName" className="mb-3">
                <Form.Label>First Name</Form.Label>
                <Form.Control type="text" placeholder="Enter First Name" onChange={(e)=>setFirstName(e.target.value)} />
            </Form.Group>
            <Form.Group controlId="formBasicLastName" className="mb-3">
                <Form.Label>Last Name</Form.Label>
                <Form.Control type="text" placeholder="Enter Last Name" onChange={(e)=>setLastName(e.target.value)} />
            </Form.Group>
            <Form.Group controlId="formBasicEmail" className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control type="email" placeholder="Enter Email" onChange={(e)=>setEmail(e.target.value)} />
            </Form.Group>
            <Button variant="primary" type="submit">Add Student</Button>
        </Form>
    )
}
export default StudentForm;