import axios from 'axios';
import React, { useState,useEffect } from 'react';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Card from 'react-bootstrap/Card';
import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import {Fragment} from 'react';
import './DataView.css';
import StudentForm from "./StudentForm";

const DataView = () => {

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(true);
    const [cardTitle, setCardTitle] = useState('');

    useEffect(() => {
        const fetchData = async () => {
            const result = await axios('http://localhost:8080/api/students');
            console.log(result)
            setData(result.data);
            setLoading(false);
        }
        fetchData().then(() => {
            const amount = data.length;
           setCardTitle("There are "+amount+" students in the database");
        })
    },[data.length]);

    const handleDelete = async(id) => {
        await axios.delete(`http://localhost:8080/api/delete/${id}`);
        setData(data.filter(item => item.id !== id));
    }
    return(

        <Container>
            <Col>
                <Row>
                   <header>
                       <h1>Student Management System</h1>
                     <StudentForm/>
                   </header>
                </Row>
            </Col>
            <Row>


                    <Table responsive={true} striped bordered hover >
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                        </tr>
                        </thead>


                        <tbody >
                        {data.map((person,index)=>{
                        return(
                           <Fragment>
                        <tr key={index}  >
                                        <td key={index}>{person.id}</td>
                                <td>{person.firstName}</td>
                                <td>{person.lastName}</td>
                                <td>{person.email}</td>
                            <Button onClick={()=>handleDelete(person.id)} variant="danger">Delete</Button>
                            </tr>
                            </Fragment>)
                        })}
                        </tbody>
                </Table>

            </Row>
        </Container>

    )
}
export default DataView;