**Basic Authentication Filter**

Wulong Lyu
**Introduction:**    

​      Spring is the most broadly used framework for the development of Java Enterprise Edition applications. The core features of Spring can be used in developing any Java application. We can use its extensions for building various web applications on top of the Jakarta EE platform, or we may just use its dependency injection provisions in simple standalone applications. 



**Overview：**

​       Spring Security is a security management framework in the Spring family. In fact, Spring Security has been developed for many years before the appearance of Spring Boot, but it is not used much.   

​       The field of security management has always been Shiro's world. Compared with Shiro, integrating Spring Security in SSM / SSH is a cumbersome operation. Therefore, although Spring Security is more powerful than Shiro, it does not use Shiro more. In other words, Shiro is enough).            

​        Since Spring Boot, Spring Boot has provided an automated configuration solution for Spring Security, and can use Spring Security with zero configuration.Spring is the most broadly used framework for the development of Java Enterprise.

![img](https://lh3.googleusercontent.com/4DA4aNt_8V-MdyxDa9XHefbQlpbIE_y-u5fwr55ONTn8Ovz_oQos5f_h-LzyhnkfOcpUDfiZxdeME6bw2oVm3OU9h50JUSDKKpC7mvF7MYxiIiiTjYEqibhnnlTVLCQVBWbpo_FK)

​         At its core is a set of filter chains that will be automatically configured after the project starts. The core is the Basic Authentication Filter used to authenticate the user's identity, a filter in spring security handles an authentication method.

![img](https://lh6.googleusercontent.com/upwa7EfEbQC3bpUnbisodFSKx_N6W9cuKb-CS5GSDOs1-OZE4P0Atufv7cYtj3GVc79cMXIeMgNlYACBhUvTTdbyHKsIdzadshDEAi2FMAQCalwT6tDxITRAXEYqD0OzYVBvUlDN)