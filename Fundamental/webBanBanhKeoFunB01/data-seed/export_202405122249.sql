REPLACE INTO [learn-java-spring-daily-store-pro-b01].dbo.customes_tbl (id,customer_code,customer_point,last_purchase_date,gen_user_info_id) VALUES
	 (N'A2749A74-7459-4BC2-883B-C7C5255A6212',N'cus-00001',0.0,NULL,N'D87CF49A-A3D9-4E53-ACAE-23CFF048839C');
REPLACE INTO [learn-java-spring-daily-store-pro-b01].dbo.general_roles_tbl (id,gen_role_code,gen_role_title) VALUES
	 (N'00879B64-B428-4B4A-A2B1-18881D315FEE',N'ss',N'Sale Staff'),
	 (N'45A671DF-8BAE-4F8E-A8D6-3FF79B157FCE',N'ad',N'Admin'),
	 (N'7BD99C7B-FFCB-408D-95C5-B49533BAFFBA',N'cus',N'Customer');
REPLACE INTO [learn-java-spring-daily-store-pro-b01].dbo.general_user_info_tbl (id,address,date_of_birth,date_of_create,date_of_last_update,email,full_name,gender,is_active,national_id,password,phone_number,user_name,gen_role_id) VALUES
	 (N'D87CF49A-A3D9-4E53-ACAE-23CFF048839C',N'test-address-b01','2000-01-24 06:00:00.000000','2024-05-11 16:08:17.801308',NULL,N'testCusEmailB01@gmail.com',N'test-cus-fullname-b01',N'Female',1,N'7475362345',N'12345678',N'858567856',N'testCusUserB01',N'7BD99C7B-FFCB-408D-95C5-B49533BAFFBA'),
	 (N'A7FCF9C9-5732-4E85-9EB3-963CF163E8E7',N'test-address-b01','1999-01-25 06:00:00.000000','2024-05-11 16:03:09.755066',NULL,N'testStaffEmailB01@gmail.com',N'test-staff-fullName-b01',N'Male',1,N'079679657868',N'12345678',N'079678567845',N'testStafUserB01',N'00879B64-B428-4B4A-A2B1-18881D315FEE');
REPLACE INTO [learn-java-spring-daily-store-pro-b01].dbo.staff_roles_tbl (id,staff_role_code,staff_role_title) VALUES
	 (N'ADF0E058-E78F-4BF5-96D3-21DC98EC23C4',N'ac',N'Accountance'),
	 (N'4F992B03-219E-4DB1-B463-364F1EC613AB',N'sam',N'Super Adminstration Manager'),
	 (N'FC904224-C1D5-4013-8985-AFE88852D66A',N'ls',N'Leader Shift'),
	 (N'51EE259F-BA76-40F2-A964-EE07B355FD6D',N'se',N'Sale Employee');
REPLACE INTO [learn-java-spring-daily-store-pro-b01].dbo.staffs_tbl (id,staff_code,gen_user_info_id,staff_role_id) VALUES
	 (N'2D624195-E327-4692-94F1-EDC683D83D93',N'ss-0001',N'A7FCF9C9-5732-4E85-9EB3-963CF163E8E7',N'51EE259F-BA76-40F2-A964-EE07B355FD6D');
