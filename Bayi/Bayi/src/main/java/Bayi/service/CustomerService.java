package Bayi.service;

import Bayi.Repository.CustomerRepository;
import Bayi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(UUID id, Customer customerDetails) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setOrderAuthorization(customerDetails.getOrderAuthorization());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> searchCustomers(String keyword) {
        return customerRepository.findAll(); // Burada anahtar kelimeye göre arama mantığını eklemelisiniz.
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        // Konsola yazdır
        customers.forEach(customer -> System.out.println(customer.toString()));

        return customers;
    }
}
