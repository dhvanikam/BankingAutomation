zephyrBaseUrl="https://prod-api.zephyr4jiracloud.com/connect"
accessKey="M2Y2ZjhjYzctNTczNS0zYTgwLTg0NWUtMmU4YzczMDYwMmM1IDYzNTgxYTM5MTNmMzcxMThkNzI2NTdkMyBVU0VSX0RFRkFVTFRfTkFNRQ"
secretKey="l-klhI9KXNnTCgUuVRfIKSU5H5me-o0iEnkjciAzaqY"
accountId="63581a3913f37118d72657d3"
echo "Generating a JSOM Web Token ..."
curl -o headers -s -d '{  "accessKey": "'"$accessKey"'"  , "secretKey": "'"$secretKey"'" ,"accountId": "'"$accountId"'","zephyrBaseUrl": "'"$zephyrBaseUrl"'","expirationTime":360000}' -H "Content-Type: application/json" -XPOST https://prod-vortexapi.zephyr4jiracloud.com/api/v1/jwt/generate
jwt="$(cat  headers | head -n 1)"
echo "The generated token:"
echo $jwt
taskName="My task"
taskDescription="Task description"
automationFramework="cucumber"
projectKey="BANKAUTO"
versionName="Unscheduled"
cycleName="cycle1"
createNewCycle="true"
appendDateTimeInCycleName="true"
folderName="RegressionTests"
createNewFolder="true"
appendDateTimeInFolderName="true"
assigneeUser="63581a3913f37118d72657d3"
resultPath="@//Users/dhvani/.jenkins/workspace/TestPipeline/target/Report.json"
mandatoryFields='{"Issue Type":[{"label":"Issue Type","value":"Test"}],"Project":[{"label":"Project","value":"BankingProjectAutomation"}],"reporter":{"label":"Dhvanika Patel","name":"Dhvanika Patel","id":"63581a3913f37118d72657d3"}}'
echo "Creating and running an automation task ..."
curl -o headers -s -v -H "accessKey: $accessKey" -H "jwt: $jwt" -H "Content-Type: multipart/form-data" -H "Content-Type: application/json" -F "jobName=$taskName" -F "jobDescription=$taskDescription" -F "automationFramework=$automationFramework" -F "projectKey=$projectKey" -F "versionName=$versionName" -F "cycleName=$cycleName" -F "createNewCycle=$createNewCycle" -F "appendDateTimeInCycleName=$appendDateTimeInCycleName" -F "folderName=$folderName" -F "createNewFolder=$createNewFolder" -F "appendDateTimeInFolderName=$appendDateTimeInFolderName" -F "assigneeUser=$assigneeUser" -F "file=$resultPath" -F "mandatoryFields=$mandatoryFields" -XPOST https://prod-vortexapi.zephyr4jiracloud.com/api/v1/automation/job/saveAndExecute
result="$(cat  headers | head -n 1)"
echo "Test results: \n"
echo $result