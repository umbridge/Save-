import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';
import SignUpPage from './container/Auth/SignUpPage';

test('renders learn react link', () => {
  render(<App />);
  // render(<SignUpPage />);
  screen.debug();
  // expect(screen.getByText(/LoginPage/)).toBeInTheDocument();
  // const linkElement = screen.getByText(/learn react/i);
  // expect(linkElement).toBeInTheDocument();
});
