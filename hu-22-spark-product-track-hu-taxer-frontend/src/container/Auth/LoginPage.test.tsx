import LoginPage from './LoginPage';
import { Button } from '@mui/material';
import React, { useState } from 'react';
import { MemoryRouter } from 'react-router-dom';
import { fireEvent, render, screen, renderHook } from '@testing-library/react';

// test('has correct input value', () => {
//   const firstname= useState<string>("User1");
//   const lastname = useState<string>("test");
//   const username= useState<string>("usertest1");
//   const email= useState<string>("user1@test.com");
//   const company_name = useState<string>("test company");
//   const password = useState<string>("User@12345");
//     render(<MemoryRouter><SignupForm  /></MemoryRouter>)
//     expect(screen.getByRole('form')).toHaveFormValues({
//       firstName: 'User1',
//       lastName: 'test',
//       username: 'usertest1',
//       email: 'test',
//       company_name: 'test company',
//       password: 'User'
//     })
//   })

test('returns registered user', () => {
    const {result} = renderHook(() => {
        const [user, setUser] = useState<boolean>(false);
        React.useEffect(() => {
          setUser(true)
        }, [])      
        return user
      })      
      expect(result.current).toBe(true)
  })


test('login user when clicked', () => {
    const handleLogin = jest.fn()
    render(<Button onClick={handleLogin}>Login</Button>)
    fireEvent.click(screen.getByText(/Login/i))
    expect(handleLogin).toHaveBeenCalledTimes(1)
})

test('renders login page', () => {
    render(<MemoryRouter><LoginPage /></MemoryRouter>);
    // Left Screen Text
    expect(screen.getByText(/Tax--/)).toBeInTheDocument();
    expect(screen.getByText(/Save More Tax in Less Time/)).toBeInTheDocument();

    // Left Screen Image
    expect(screen.getByAltText(/authImg/)).toBeInTheDocument();

    // Form Labels
    expect(screen.getByText(/Welcome Back!/)).toBeInTheDocument();
    expect(screen.getByText(/Username/)).toBeInTheDocument();
    expect(screen.getByText(/Forgot Password/)).toBeInTheDocument();


    expect(screen.getByRole('heading', { level: 4 })).toBeInTheDocument();
    expect(screen.getByRole('button')).toBeInTheDocument();


    //Form Placeholders
    expect(screen.getByPlaceholderText(/Enter your Username/)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Enter your Password/)).toBeInTheDocument();

});
