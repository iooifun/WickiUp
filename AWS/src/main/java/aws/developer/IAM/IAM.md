## IAM -  Identity Access Management  

https://aws.amazon.com/ru/iam/

**Allows you yo manage users and their level of access to the AWS console.** 

**What does IAM give you**

1. Centralised control of your AWS account
2. Shared Access to your AWS account
3. Granular permission
4. Identity Federation (including Active Directory, Facebook, Linkedin) 
5. Multi-factor Authentication
6. Provide temporary access for users/devices and services where necessary
7. Allows you to set up your own password rotation policy
8. Integrates with many different AWS services 
9. Support PCI DSS Compliance
10. IAM consists of the following:
	 - Users
	 - Groups (A way to group our users and apply polices to them collectively) 
	 - Roles
	 - Policy Documents
11. IAM is universal. It does not apply to regions at this time 	 
12. The `root account` is simply the account created when first setup your AWS account. It has complete Admin access by default
13. New Users have NO permissions when first created
14. New Users are assigned Access Key ID & Secret Access Keys when first created
15. These are not the same as a password, and you cannot use the Access KeyID & Secret Access Key to Login in to the console. You can use this to access AWS via the APIs and Command Line however
16. You only get to view these once. If you lose them, you have to regenerate them. So save them in a secure location.
17. Always setup Multi-factor Authentication on yur root account
19 You can create and customise your own password rotation policies

IAM does not require region election:

![IAM does not require region election](../images/IAM/IAM_not_require_reqion.png)

IAM users sign-in link:

![IAM does not require region election](../images/IAM/IAM_user_link.png)


**Critical Terms**:

1. `Users` - End Users (think people) 

 	- How to create user:
 	
	![IAM does not require region election](../images/IAM/add_user_1.png)
	
	![IAM does not require region election](../images/IAM/add_user_2.png)
	
	- Access type:
		- Programmatic access.
		
		  Enables an access key ID and secret access key for the AWS API, CLI, SDK, and other development tools
		  
		- AWS Management Console access.
		
		  Enables a password that allow users to sing-in to te AWS Management console
		  
	![IAM does not require region election](../images/IAM/add_user_3.png)	  
	
	![IAM does not require region election](../images/IAM/add_user_4.png)
	
	![IAM does not require region election](../images/IAM/add_user_5.png)
	
	![IAM does not require region election](../images/IAM/add_user_6.png)
 	
2. `Groups` - A collection of users under one set of permission

	![IAM does not require region election](../images/IAM/add_group_1.png)
	
	![IAM does not require region election](../images/IAM/add_group_2.png)
	
	![IAM does not require region election](../images/IAM/add_group_3.png)
	
	![IAM does not require region election](../images/IAM/add_group_4.png)
	
	![IAM does not require region election](../images/IAM/add_group_5.png)
	
3. `Roles` - You create roles and can then assign them to AWS resources

	AWS identity with permission policies that determine what the identity can and cannot do in AWS.
	However, instead of being uniquely associated with one person, a role is intended to be assumable by anyone who needs it. 
	Also, a role does not have any credentials (password or access keys) associated with it. 
	Instead, if a user is assigned to a role, access keys are created dynamically and provided to the user.
	You can use roles to delegate access to users, applications, or services that don't normally have access to your AWS resources
	
	![IAM does not require region election](../images/IAM/add_role_1.png)
	
	![IAM does not require region election](../images/IAM/add_role_2.png)
	
	![IAM does not require region election](../images/IAM/add_role_3.png)
	
4. `Policies` - A document that defines one or more permissions
	- To assign permissions to a user, group, role, or resource, you create a policy, which is a document that explicitly lists permissions. 
	  In its most basic sense, a policy lets you specify the following:
		- Actions: what actions you will allow. Each AWS service has its own set of actions. For example, you might allow a user to use the Amazon S3 ListBucket action, which returns information about the items in a bucket. Any actions that you don't explicitly allow are denied.
		- Resources: which resources you allow the action on. For example, what specific Amazon S3 buckets will you allow the user to perform the ListBucket action on? Users cannot access any resources that you have not explicitly granted permissions to.
		- Effect: what the effect will be when the user requests access—either allow or deny. Because the default is that resources are denied to users, you typically specify that you will allow users access to resource.
		
	![IAM does not require region election](../images/IAM/policies.png)	
	
	![IAM does not require region election](../images/IAM/policies_1.png)	


5. `MFA` - multi-factor authentication

	![IAM does not require region election](../images/IAM/mfa_1.png)
	
	![IAM does not require region election](../images/IAM/mfa_2.png)
	
	![IAM does not require region election](../images/IAM/mfa_3.png)
	
	![IAM does not require region election](../images/IAM/mfa_4.png)
	
	![IAM does not require region election](../images/IAM/mfa_5.png)

6. `Root account` - email for sign up to AWS
	- When you first create an Amazon Web Services (AWS) account, you begin with a single sign-in identity that has complete access to all AWS services and resources in the account. 
	  This identity is called the AWS account root user and is accessed by signing in with the email address and password that you used to create the account.

7. `Access key ID` and `Secret Access key` - token would you use in order to programmatically interact with AWS you can't use them to login to AWS console
		
	![IAM does not require region election](../images/IAM/access_sercet_keys.png)

**IAM Best practices**	

Enables you to control who can do what in your AWS account

Users, groups, roles and permissions

Control
	- Centralized
	- Fine-grained - APIs, resources, and AWS console
Security
	- Secure by default
	- Multiple users, individual security credentials and permissions
	

---

### Security Token Service (STS)

![AMI](../images/IAM/IAM-1.png)	

![AMI](../images/IAM/IAM-2.png)	

![AMI](../images/IAM/IAM-3.png)	

![AMI](../images/IAM/IAM-4.png)

![AMI](../images/IAM/IAM-5.png)

![AMI](../images/IAM/IAM-6.png)

![AMI](../images/IAM/IAM-7.png)

![AMI](../images/IAM/IAM-8.png)
		
**Active Directory Federation (On exam)**

![AM](../images/IAM/IAM-9.png)

1. Can you authenticate with active directory?
	- Yes, using SAML
2. What type of authenticate?
	- SAML (security assertion markup language)
3. Whether or not your authenticating to active directory first and then giving a temporal security credential 
	or if you get a temporal security credential first which is then authenticate against to active directory?
	- You always authenticate to active directory first and then you will be assign security credential
4. What is Arn?
	- Amazon Resource Name
5. Have you to create new role in new region?
	- No, because all roles are global
6. Weather or not is it possible to attach role	to running EC2 instance
	- It is now possible
	
**Web Identity Federation (WIF)**	

This allows a developer to federate their application from Facebook, Google, or Amazon with their AWS account, allowing their end users to authenticate with one of these Identity Providers (IdP) and receive temporary AWS credentials. 
In combination with Policy Variables, WIF allows the developer to restrict end users' access to a subset of AWS resources within their account.

![AM](../images/IAM/IAM-10.png)

![AM](../images/IAM/IAM-11.png)

![AM](../images/IAM/IAM-12.png)

![AM](../images/IAM/IAM-13.png)

![AM](../images/IAM/IAM-14.png)

![AM](../images/IAM/IAM-15.png)

![AM](../images/IAM/IAM-16.png)

Have to be remembered for exam:

First you authenticate with Identity Provider, you then obtain security credentials and then
you call AssumeRoleWithWebIdentity and then when you done it you are able to access AWS resource

---

**IAM Summary**

![AM](../images/IAM/IAM-17.png)

![AM](../images/IAM/IAM-18.png)

![AM](../images/IAM/IAM-19.png)
