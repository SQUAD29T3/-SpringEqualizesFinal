package br.com.equalizes.model;

public class Perfil {

  private int id;

  private boolean enabled;
  private boolean accountNonExpired;
  private boolean credentialNonExpired;
  private boolean accountNonLocked;
  // private Collection<? extends GrantedAuthority> authorities;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(final boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public boolean isCredentialNonExpired() {
    return credentialNonExpired;
  }

  protected Perfil() {
  };

  public void setCredentialNonExpired(final boolean credentialNonExpired) {
    this.credentialNonExpired = credentialNonExpired;
  }

  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  public boolean isCredentialsNonExpired() {
    return false;
  }

  public void setAccountNonLocked(final boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  // @Override
  // public Collection<? extends GrantedAuthority> getAuthorities() {
  // return authorities;
  // }

  public String getPassword() {
    return null;
  }

  public String getUsername() {
    return null;
  }

  // public void setAuthorities(final Collection<? extends GrantedAuthority>
  // authorities) {
  // this.authorities = authorities;
  // }

  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }
}
