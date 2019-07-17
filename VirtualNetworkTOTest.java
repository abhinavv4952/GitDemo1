package com.cloud.agent.api.VirtualNetwork;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
  For Virtual Network backward compatibility any change in the TO member/constructor change the test cases in this class will fail.
  Take approprivate decision by refering the VR backward compatibity feature FS.
  The objective is NOT to brea the VR configuration backward compatibility.
 */
public class VirtualNetworkTOTest {

    /*
    These tests for VR configuration backward compatiblie on upgrade to newer version.
    The backward will break if any configuration got deleted or modified existing param.
    These test will detect this kind of configuration change.

    On these test failures developer need to relook at the configuration parameter change, try
    for the backward compatibility.

    https://www.logicbig.com/how-to/code-snippets/jcode-reflection-field-getgenerictype.html
     */

    enum DummyEnum{
        dummy
    }

    @Test
     public void AclRuleTOConstructorTest() {

        AclRule aclto = new AclRule();
        Class<?> aclToClass = aclto.getClass();

        Field fields[] = aclToClass.getDeclaredFields();
        Constructor<?>[] constructors = aclToClass.getDeclaredConstructors();

        Assert.assertEquals(2, fields.length);
        Assert.assertEquals(2, constructors.length);//Constructors are protected
    }

     @Test
    public void AclRuleTOParamTest() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
    	/* 
    	private String cidr;
    	private boolean allowed;
		*/    
		VirtualNetworkTOTestUtil virtualnetworktotestutil=new VirtualNetworkTOTestUtil();

		virtualnetworktotestutil.checkParamType(AclRule.class,"cidr","java.lang.String",true);

		virtualnetworktotestutil.checkParamType(AclRule.class,"allowed","boolean",true);


    }

    @Test
     public void DhcpConfigEntryTOConstructorTest() {

        DhcpConfigEntry dhcpconfigentry = new DhcpConfigEntry();
        Class<?> dhcpconfigentryToClass = dhcpconfigentry.getClass();

        Field fields[] = dhcpconfigentryToClass.getDeclaredFields();
        Constructor<?>[] constructors = dhcpconfigentryToClass.getDeclaredConstructors();

        Assert.assertEquals(4, fields.length);
        Assert.assertEquals(2, constructors.length);
    }

     @Test
    public void DhcpConfigEntryTOParamTest() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
    	/*
    	private String routerIpAddress;
    	private String gateway;
    	private String netmask;
    	private String firstIpOfSubnet;  
    	*/  
		VirtualNetworkTOTestUtil virtualnetworktotestutil=new VirtualNetworkTOTestUtil();

		List<String> strMembers = new ArrayList<String>(Arrays.asList("routerIpAddress", "gateway","netmask","firstIpOfSubnet"));

		 for(String str : strMembers){
            virtualnetworktotestutil.checkParamType(DhcpConfigEntry.class, str, "java.lang.String", true);
        }
	}

	@Test
     public void GuestNetworkTOConstructorTest() {

        GuestNetwork guestnetwork = new GuestNetwork();
        Class<?> guestnetworkToClass = guestnetwork.getClass();

        Field fields[] = guestnetworkToClass.getDeclaredFields();
        Constructor<?>[] constructors = guestnetworkToClass.getDeclaredConstructors();

        Assert.assertEquals(9, fields.length);
        Assert.assertEquals(2, constructors.length);
    }

    @Test
    public void GuestNetworkTOParamTest() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
    	/*
    	private boolean add;
    	private String macAddress;
	    private String device;
    	private String routerGuestIp;
    	private String routerGuestNetmask;
    	private String routerGuestGateway;
    	private String cidr;
    	private String dns;
 	    private String domainName;
     	*/  
		VirtualNetworkTOTestUtil virtualnetworktotestutil=new VirtualNetworkTOTestUtil();
		virtualnetworktotestutil.checkParamType(GuestNetwork.class,"add","boolean",true);
		List<String> strMembers = new ArrayList<String>(Arrays.asList( "macAddress","device","routerGuestIp","routerGuestNetmask","routerGuestGateway","cidr","dns","domainName"));

		 for(String str : strMembers){
            virtualnetworktotestutil.checkParamType(GuestNetwork.class, str, "java.lang.String", true);
        }	
	}

	@Test
     public void IpAssociationTOConstructorTest() {

        IpAssociation ipassociation = new IpAssociation();
        Class<?> ipassociationToClass = ipassociation.getClass();

        Field fields[] = ipassociationToClass.getDeclaredFields();
        Constructor<?>[] constructors = ipassociationToClass.getDeclaredConstructors();

        Assert.assertEquals(1, fields.length);
        Assert.assertEquals(2, constructors.length);
    }

    @Test
    public void IpAssociationTOParamTest() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
    	/*
    	 private IpAddress[] ipAddress;
     	*/  
		/*
			Field field = IpAssociation.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        System.out.println(field.getType());


		*/	
	}

	@Test
     public void NetworkACLTOConstructorTest() {

        NetworkACL networkacl = new NetworkACL();
        Class<?> networkaclToClass = networkacl.getClass();

        Field fields[] = networkaclToClass.getDeclaredFields();
        Constructor<?>[] constructors = networkaclToClass.getDeclaredConstructors();

        Assert.assertEquals(8, fields.length);
        Assert.assertEquals(2, constructors.length);
    }

      @Test
    public void NetworkACLTOParamTest() throws NoSuchFieldException, InstantiationException, IllegalAccessException {
    	/*
    	private String device;
	    private String macAddress;
	    private boolean privateGatewayAcl;
	    private String nicIp;
	    private String nicNetmask;
	    private AclRule[] ingressRules;
	    private AclRule[] egressRules;
	    private String defaultAcl;
     	*/  
		/*
			Field field = IpAssociation.getDeclaredField(memName);
        if(isPrivate) {
            field.setAccessible(true);
        }
        System.out.println(field.getType());


		*/
        VirtualNetworkTOTestUtil virtualnetworktotestutil=new VirtualNetworkTOTestUtil();
        virtualnetworktotestutil.checkParamType(GuestNetwork.class,"privateGatewayAcl","boolean",true);
        List<String> strMembers = new ArrayList<String>(Arrays.asList("device","macAddress","nicIp","nicNetmask","defaultAcl"));

		 for(String str : strMembers){
            virtualnetworktotestutil.checkParamType(NetworkACL.class, str, "java.lang.String", true);
        }
        /*
        	Check for ingress and egrees rules
        */

	}










}



