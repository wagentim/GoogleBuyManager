package cn.wagentim.buymanager.entities;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CustomerEntity
 *
 */
@Entity
@Table(name="CustomerEntity")
public final class CustomerEntity implements Serializable, IEntityStatus {

	/**
     *
     */
    private static final long serialVersionUID = -5566222048161244290L;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String telefon;
	private String address;
	private String other;
	private String contury;
	private String province;
	private String city;
	private String zipcode;
	private String securityQues;
	private String securityAnsw;
    private String email;
    private String pwd;

	/** user name */
	private String alias;

	/** The Auth code */
	private String md5;

	/** indicate the assign time of the Auth MD5 code */
	private String validationStart;

	/** indicate that this customer entity is new created or has been modified */
	@Transient
	private int status = CUSTOMER_STATUS_NULL;


    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getTelefon()
    {
        return telefon;
    }
    public void setTelefon(String telefon)
    {
        this.telefon = telefon;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getOther()
    {
        return other;
    }
    public void setOther(String other)
    {
        this.other = other;
    }
    public String getContury()
    {
        return contury;
    }
    public void setContury(String contury)
    {
        this.contury = contury;
    }
    public String getProvince()
    {
        return province;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public String getZipcode()
    {
        return zipcode;
    }
    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }
    public String getSecurityQues()
    {
        return securityQues;
    }
    public void setSecurityQues(String securityQues)
    {
        this.securityQues = securityQues;
    }
    public String getSecurityAnsw()
    {
        return securityAnsw;
    }
    public void setSecurityAnsw(String securityAnsw)
    {
        this.securityAnsw = securityAnsw;
    }
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getPwd()
    {
        return pwd;
    }
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
    public String getAlias()
    {
        return alias;
    }
    public void setAlias(String alias)
    {
        this.alias = alias;
    }
    public String getMd5()
    {
        return md5;
    }
    public void setMd5(String md5)
    {
        this.md5 = md5;
    }
    public String getValidationStart()
    {
        return validationStart;
    }
    public void setValidationStart(String validationStart)
    {
        this.validationStart = validationStart;
    }
    public int getStatus()
    {
        return status;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( alias == null ) ? 0 : alias.hashCode() );
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if ( this == obj ) return true;
        if ( obj == null ) return false;
        if ( getClass() != obj.getClass() ) return false;
        CustomerEntity other = (CustomerEntity)obj;
        if ( alias == null )
        {
            if ( other.alias != null ) return false;
        }
        else if ( !alias.equals(other.alias) ) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "CustomerEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telefon=" + telefon + ", address=" + address + ", other=" + other
                + ", contury=" + contury + ", province=" + province + ", city=" + city + ", zipcode=" + zipcode + ", securityQues=" + securityQues + ", securityAnsw="
                + securityAnsw + ", email=" + email + ", pwd=" + pwd + ", alias=" + alias + ", md5=" + md5 + ", validationStart=" + validationStart + ", status="
                + status + "]";
    }

}
