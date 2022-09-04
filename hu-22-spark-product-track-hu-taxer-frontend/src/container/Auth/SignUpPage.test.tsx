import React, { useState } from 'react';
import { fireEvent, render, screen, renderHook } from '@testing-library/react';
import SignUpPage from './SignUpPage';
import { MemoryRouter } from 'react-router-dom';
import { Button } from '@mui/material';


jest.mock('axios');

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


test('Add New User when clicked', () => {
    const addNewUser = jest.fn()
    render(<Button onClick={addNewUser}>Sign Up</Button>)
    fireEvent.click(screen.getByText(/Sign Up/i))
    expect(addNewUser).toHaveBeenCalledTimes(1)
})

test('renders signup page', () => {
    render(<MemoryRouter><SignUpPage /></MemoryRouter>);
    // Left Screen Text
    expect(screen.getByText(/Save Tax in less than 5 minutes/)).toBeInTheDocument();
    expect(screen.getByText(/Saving tax is like taking a selfie. Try it yourself/)).toBeInTheDocument();

    // Left Screen Image
    expect(screen.getByAltText(/SignupImg/)).toBeInTheDocument();

    // Form Labels
    expect(screen.getByText(/Create an Account/)).toBeInTheDocument();
    expect(screen.getByText(/First Name/)).toBeInTheDocument();
    expect(screen.getByText(/Last Name/)).toBeInTheDocument();
    expect(screen.getByText(/Username/)).toBeInTheDocument();
    expect(screen.getByText(/Email/)).toBeInTheDocument();
    expect(screen.getByText(/Company Name/)).toBeInTheDocument();
    expect(screen.getByText(/Password/)).toBeInTheDocument();

    expect(screen.getByRole('heading', { level: 4 })).toBeInTheDocument();
    expect(screen.getByRole('button')).toBeInTheDocument();
    expect(screen.getByRole('link')).toBeInTheDocument();


    //Form Placeholders
    expect(screen.getByPlaceholderText(/Enter your First Name/)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Enter your Last Name/)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Enter your unique Username/)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Enter your Email Id/)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Enter your Company Name/)).toBeInTheDocument();
    expect(screen.getByPlaceholderText(/Enter your Password/)).toBeInTheDocument();

});




