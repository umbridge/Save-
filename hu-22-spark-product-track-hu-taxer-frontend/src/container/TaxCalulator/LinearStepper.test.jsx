import React, { useState } from 'react';
import TaxPage from './TaxPage';
import LinaerStepper from './LinearStepper';
import { fireEvent, render, screen, renderHook } from '@testing-library/react';
import { MemoryRouter } from 'react-router-dom';
import { Button } from '@mui/material';
import axios from 'axios';

import userEvent from '@testing-library/user-event';
import LinearStepper from './LinearStepper';
import BasicForm from './BasicForm';
import IncomeDetails from './IncomeDetails';

test('renders linear stepper', () => {
    render(<MemoryRouter><LinearStepper /></MemoryRouter>);
    expect(screen.getByText(/Basic information/)).toBeInTheDocument();
    expect(screen.getByText(/Income Details/)).toBeInTheDocument();
    expect(screen.getByText(/Deductions/)).toBeInTheDocument();
    expect(screen.getByText(/Summary/)).toBeInTheDocument();
    expect(screen.getByText(/back/)).toBeInTheDocument();
    expect(screen.getByText(/Next/)).toBeInTheDocument();
}
)

// test('has correct input value', () => {
  // const firstname= useState<string>("User1");
  // const lastname = useState<string>("test");
  // const username= useState<string>("usertest1");
  // const email= useState<string>("user1@test.com");
  // const company_name = useState<string>("test company");
  // const password = useState<string>("User@12345");
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

// jest.mock('axios');

// describe('SignUpPage', () => {
//   test('Add New User to an API', async () => {
//   const user = true;

//     axios.post.mockImplementationOnce(() =>
//     Promise.resolve({ data: { user } })
//     );

//     render(<MemoryRouter><SignUpPage /></MemoryRouter>);

//     await userEvent.click(screen.getByRole('button'));

//     const items = await screen.findAllByRole('listitem');

//     expect(items).toHaveLength(2);
//   });
// });
// test('returns registered user', () => {
//     const {result} = renderHook(() => {
//         const [user, setUser] = useState<boolean>(false);
//         React.useEffect(() => {
//           setUser(true)
//         }, [])      
//         return user
//       })      
//       expect(result.current).toBe(true)
//   })


// test('Add New User when clicked', () => {
//     const addNewUser = jest.fn()
//     render(<Button onClick={addNewUser}>Sign Up</Button>)
//     fireEvent.click(screen.getByText(/Sign Up/i))
//     expect(addNewUser).toHaveBeenCalledTimes(1)
// })


// test('renders basic information', () => {
//     render(<MemoryRouter><BasicForm /></MemoryRouter>);

//     // Form Labels
//     expect(screen.getByText(/Which Financial Year do you want to calculate taxes for?/)).toBeInTheDocument();
//     expect(screen.getByText(/Gender/)).toBeInTheDocument();
//     expect(screen.getByText(/Age/)).toBeInTheDocument();
// })

// test('renders income details', () => {
//     render(<MemoryRouter><IncomeDetails /></MemoryRouter>);

//     expect(screen.getByText(/Basic Income/)).toBeInTheDocument();
//     expect(screen.getByText(/Rental Income/)).toBeInTheDocument();
//     expect(screen.getByText(/Business Income/)).toBeInTheDocument();
//     expect(screen.getByText(/Capital Gains/)).toBeInTheDocument();
//     expect(screen.getByText(/Income From Other Sources/)).toBeInTheDocument();



    /* *****************Under Section 80C******************** */
    // expect(screen.getByText(/Under Section 80C/)).toBeInTheDocument();
    // expect(screen.getByText(/Investment under equity saving scheme/)).toBeInTheDocument();
    // expect(screen.getByText(/Employee's contribution towards EPF/)).toBeInTheDocument();
    // expect(screen.getByText(/5 Years fixed deposit/)).toBeInTheDocument();
    // expect(screen.getByText(/Home Loan Principal Repayment/)).toBeInTheDocument();
    // expect(screen.getByText(/Life Insurance premium paid/)).toBeInTheDocument();
    // expect(screen.getByText(/Contribution toward ULIP/)).toBeInTheDocument();
    // expect(screen.getByText(/Investment in NSC/)).toBeInTheDocument();
    // expect(screen.getByText(/Contribution toward provident fund/)).toBeInTheDocument();
    // expect(screen.getByText(/Deposit with Sukanya Samriddhi Accounts/)).toBeInTheDocument();
    // expect(screen.getByText(/Tuition fees paid for children/)).toBeInTheDocument();
    // expect(screen.getByText(/Self-employed contribution toward NPS/)).toBeInTheDocument();


    /* *****************Under Section 10******************** */
    // expect(screen.getByText(/Under Section 10/)).toBeInTheDocument();
    // expect(screen.getByText(/Child Education allowance/)).toBeInTheDocument();
    // expect(screen.getByText(/Child Hostel Allowance/)).toBeInTheDocument();
    // expect(screen.getByText(/Actual House Rent Allowance received/)).toBeInTheDocument();
    // expect(screen.getByText(/Actual Rent paid/)).toBeInTheDocument();
    // expect(screen.getByText(/Do you live in Metro City /)).toBeInTheDocument();
    // expect(screen.getByText(/Leave Travel Allowance/)).toBeInTheDocument();
    // expect(screen.getByText(/Amount/)).toBeInTheDocument();
    // expect(screen.getByText(/Under Section 24/)).toBeInTheDocument();
    // expect(screen.getByText(/Rent of Property/)).toBeInTheDocument();
    // expect(screen.getByText(/Property Tax/)).toBeInTheDocument();
    // expect(screen.getByText(/Interest on Home loan taken/)).toBeInTheDocument();
    // expect(screen.getByText(/Loss from House Property/)).toBeInTheDocument();
    // expect(screen.getByText(/Other Deductions/)).toBeInTheDocument();
    // expect(screen.getByText(/Medical Insurance premium/)).toBeInTheDocument();
    // expect(screen.getByText(/Additional contribution towards NPS/)).toBeInTheDocument();
    // expect(screen.getByText(/Employer's contribution toward EPF/)).toBeInTheDocument();
    // expect(screen.getByText(/Donations/)).toBeInTheDocument();
    // expect(screen.getByText(/Employer's contribution toward NPS/)).toBeInTheDocument();
    // expect(screen.getByText(/Interest on loan for higher education/)).toBeInTheDocument();
    // expect(screen.getByText(/Interest on deposits in saving account/)).toBeInTheDocument();
    // expect(screen.getByText(/Interest on loan taken for Residential House/)).toBeInTheDocument();

    // expect(screen.getByRole('heading', { level: 3 })).toBeInTheDocument();
    // expect(screen.getByRole('button')).toBeInTheDocument();
    // expect(screen.getByRole('link')).toBeInTheDocument();


    //Form Placeholders
    // expect(screen.getByPlaceholderText(/Enter your Basic Income/)).toBeInTheDocument();
    // expect(screen.getByPlaceholderText(/Enter your Rental Income/)).toBeInTheDocument();
    // expect(screen.getByPlaceholderText(/Enter your Business Income/)).toBeInTheDocument();
    // expect(screen.getByPlaceholderText(/Enter your Capital Gains/)).toBeInTheDocument();
    // expect(screen.getByPlaceholderText(/Enter your Other Income/)).toBeInTheDocument();
    // expect(screen.getByPlaceholderText(/We will Calculate it/)).toBeInTheDocument();

// });