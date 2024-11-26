package edu.lawrence.getoutdoors.security;

// Java-level includes [Util]
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Spring-level includes [Interfaces]
import org.springframework.security.core.userdetails.UserDetails;

// Spring-level includes [Security Helpers]
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AppUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private String userid;
	private List<GrantedAuthority> authorities;
	
	public AppUserDetails(String id) {
		userid = id;
		authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userid;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}