

# ECS 153 - Proposal 

## (1) what problem are you solving

Design a Login System with appropriate features to enhance its security. 



## (2) why is it important

- Protecting the privacy
- Since the Login system is almost a requirement for all applications. It deserves to explore how to build a general secure and user-friendly login system.
- Getting a better sense of backend development, frontend implementation, database design, network, and computer security. 



## (3) what do you plan to build

We plan to develop a login system from the ground up, including front-end implementation(VUE.js), backend development(Spring), and database(sql) design. The server is going to be one of our local computers, and all the other devices within the same Local Area Network could get access to the server and test the robustness of our system.



- The login system has the following features:
  - Long-distance login reminder using Websocket technology for communication
  - Automatic Logon with cookie
  - limit login attempts
  - robot test page, including 
  - Multiple login limitation
  - Log out
  - Question check
  - Password encryption



- We’ll also research the general login attacks to build a better login system. 



## (4) what are your expected results

 (Results based on features) 

- It limits multiple device logins that the last login edges out the previous one, a dialog pops up on the previous one and it automatically returns to re-login page.
- It provides checkbox giving option of automatic login for seven days on the login page 
- We’ll have a slider-verification-code to run the robot test.
- We’ll set a limitation on login attempts. If the user goes beyond the limit, we’ll block the account temporarily, and provide a page to further verification.
- Users can choose to log out automatically with long time no operations
- When users register with email, users can set several questions for checking, which can be used as a security check for resetting passwords, etc.