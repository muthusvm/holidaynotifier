CREATE TABLE TEST_HM(
  id     INTEGER  ,
    area_code VARCHAR2(45) ,
    area_name VARCHAR2(200) ,
    holiday_date DATE ,
    HOLIDAY_DESC VARCHAR2(400) ,
    HOLIDAY_TYPE        VARCHAR2(45));
 DROP TABLE   TEST_HM; 


INSERT INTO   TEST_HM(id,area_code,area_name,holiday_date,HOLIDAY_DESC,HOLIDAY_TYPE) values(1,'100','Chennai','01-05-2019','May 1st','National')
