import axios from "axios";
import { useEffect } from "react";
import React,{useState} from "react";

function Home() {
    const [showUsers, setShowUsers] = useState(false);
    const toggleUsersList = () => {
        setShowUsers(!showUsers);
    };
    const [userInfo, setUserInfo] = useState({
        name: '',
        email: ''
    });
    const { name, email } = userInfo;
    const handleChange = (e) => {
        const { name, value } = e.target;
        setUserInfo({
            ...userInfo,
            [name]: value
        });
    }
        const [users, setUsers] = useState([]);
        
        const getUsers= ()=>{ axios.get('http://localhost:8080/db/users')
            .then(response => {setUsers(response.data);
                console.log("Users data fetched:", response.data)})
            .catch(error => console.error("Error fetching users data:", error));

        };
    useEffect(() => {  getUsers(); }, []); 
    
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("User Info Submitted:", userInfo);
            axios.post('http://localhost:8080/users', userInfo)
            .then(response => {
                console.log("User added successfully:", response.data);
                setUsers([...users, response.data]); // Update users list with new user
                setUserInfo({ name: '', email: '' }); // Reset form fields
                getUsers(); // Refresh the users list
            })
            .catch(error => console.error("Error adding user:", error));
        
    };

    const handleDelete = (id) => {
        axios.delete(`http://localhost:8080/db/users/${id}`)
            .then(response => {
                console.log("User deleted successfully:", response.data);
                setUsers(users.filter(user => user.id !== id)); // Update users list after deletion
            })
            .catch(error => console.error("Error deleting user:", error));
    }

    const handleUpdate = (id, updatedUser) => {
        axios.put(`http://localhost:8080/db/users/${id}`, updatedUser)
            .then(response => {
                console.log("User updated successfully:", response.data);
                setUsers(users.map(user => (user.id === id ? response.data : user))); // Update users list with updated user
            })
            .catch(error => console.error("Error updating user:", error));
    }



  return (
    <div className="home">
      <h1>Welcome to MyApp</h1>
      <p>This is the home page of your application.</p>
      <p>Use the navigation bar to explore different sections.</p>
      <p>Enter the User Info in the below form</p>
      <center>
        <form onSubmit={handleSubmit}>
            <label>
                Name:
                <input type="text" name="name" placeholder="Enter your name"  value={name} onChange={handleChange}/>
            </label>
            <br />
            <label>
                Email:
                <input type="email" name="email" placeholder="Enter your email"  value={email} onChange={handleChange}/>
            </label>
            <br />
            <button type="submit" >Submit</button>
        </form>
        <br />
        <button onClick={toggleUsersList}>
          {showUsers ? "Hide Users List" : "Show Users List"}
        </button>

        {showUsers && (
          <>
            <h3>Users List</h3>
            <table border="1">
              <thead>
                <tr><th>ID</th><th>Name</th><th>Email</th></tr>
              </thead>
              <tbody>
                {users.map((user,index) => (
                  <tr key={user.id||index}>
                    <td>{user.id}</td><td>{user.name}</td><td>{user.email}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </>
        )}
        <h3>Delete User</h3>
        <form onSubmit={(e) => {
            e.preventDefault();
            const userId = prompt("Enter the ID of the user to delete:");
            if (userId) {
                handleDelete(userId);
            }
            getUsers(); // Refresh the users list after deletion
        }}>
            <button type="submit">Delete User</button>
        </form>
      </center>

    </div>
  );
}
export default Home;