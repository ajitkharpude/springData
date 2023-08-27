package com.example.demo.Controller;
/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import java.util.Collection;

/**
* Provides core user information.
*
* <p>
* Implementations are not used directly by Spring Security for security purposes. They
* simply store user information which is later encapsulated into {@link Authentication}
* objects. This allows non-security related user information (such as email addresses,
* telephone numbers etc) to be stored in a convenient location.
* <p>
* Concrete implementations must take particular care to ensure the non-null contract
* detailed for each method is enforced. See
* {@link org.springframework.security.core.userdetails.User} for a reference
* implementation (which you might like to extend or use in your code).
*
* @author Ben Alex
* @see UserDetailsService
* @see UserCache
*/
public interface UserDetails{

	Collection getAuthorities();
	String getPassword();
	String getUsername();
	boolean isAccountNonExpired();
	boolean isAccountNonLocked();
	boolean isCredentialsNonExpired();
	boolean isEnabled();

}
