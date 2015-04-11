package model.dataset;

public class DatasetBean {	
	private int id;
	private String name = "";
	private String fileFormat = "";
	private String savingPath = "";
	private String source = "";
	private String creator = "";
	private String creatorCompany = "";
	private String creatorAddress = "";
	private String creatorZipcode = "";
	private String creatorTelephone = "";
	private String creatorEmail = "";
	private String recordsNo = "";
	private String fieldsNo = "";
	private String size = "";
	private String relationalCategory = "";
	private String metadataDescription = "";
	private String uploader = "";
	private String uploaderCompany = "";
	private String uploaderAddress = "";
	private String uploaderZipcode = "";
	private String uploaderTelephone = "";
	private String uploaderEmail = "";
	private String createTime = "";
	private String uploadTime = "";
	private String lastModificationTime = "";
	private String description = "";
	private int count; //call counter
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFileFormat() {
			return fileFormat;
		}
		public void setFileFormat(String fileFormat) {
			this.fileFormat = fileFormat;
		}
		public String getSavingPath() {
			return savingPath;
		}
		public void setSavingPath(String savingPath) {
			this.savingPath = savingPath;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getCreatorCompany() {
			return creatorCompany;
		}
		public void setCreatorCompany(String creatorCompany) {
			this.creatorCompany = creatorCompany;
		}
		public String getCreator() {
			return creator;
		}
		public void setCreator(String creator) {
			this.creator = creator;
		}
		public String getCreatorAddress() {
			return creatorAddress;
		}
		public void setCreatorAddress(String creatorAddress) {
			this.creatorAddress = creatorAddress;
		}
		public String getCreatorZipcode() {
			return creatorZipcode;
		}
		public void setCreatorZipcode(String creatorZipcode) {
			this.creatorZipcode = creatorZipcode;
		}
		public String getCreatorTelephone() {
			return creatorTelephone;
		}
		public void setCreatorTelephone(String creatorTelephone) {
			this.creatorTelephone = creatorTelephone;
		}
		public String getCreatorEmail() {
			return creatorEmail;
		}
		public void setCreatorEmail(String creatorEmail) {
			this.creatorEmail = creatorEmail;
		}
		public String getRecordsNo() {
			return recordsNo;
		}
		public void setRecordsNo(String recordsNo) {
			this.recordsNo = recordsNo;
		}
		public String getFieldsNo() {
			return fieldsNo;
		}
		public void setFieldsNo(String fieldsNo) {
			this.fieldsNo = fieldsNo;
		}
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getRelationalCategory() {
			return relationalCategory;
		}
		public void setRelationalCategory(String relationalCategory) {
			this.relationalCategory = relationalCategory;
		}
		public String getMetadataDescription() {
			return metadataDescription;
		}
		public void setMetadataDescription(String metadataDescription) {
			this.metadataDescription = metadataDescription;
		}
		public String getUploader() {
			return uploader;
		}
		public void setUploader(String uploader) {
			this.uploader = uploader;
		}
		public String getUploaderCompany() {
			return uploaderCompany;
		}
		public void setUploaderCompany(String uploaderCompany) {
			this.uploaderCompany = uploaderCompany;
		}
		public String getUploaderAddress() {
			return uploaderAddress;
		}
		public void setUploaderAddress(String uploaderAddress) {
			this.uploaderAddress = uploaderAddress;
		}
		public String getUploaderZipcode() {
			return uploaderZipcode;
		}
		public void setUploaderZipcode(String uploaderZipcode) {
			this.uploaderZipcode = uploaderZipcode;
		}
		public String getUploaderTelephone() {
			return uploaderTelephone;
		}
		public void setUploaderTelephone(String uploaderTelephone) {
			this.uploaderTelephone = uploaderTelephone;
		}
		public String getUploaderEmail() {
			return uploaderEmail;
		}
		public void setUploaderEmail(String uploaderEmail) {
			this.uploaderEmail = uploaderEmail;
		}
		public String getCreateTime() {
			return createTime;
		}
		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}
		public String getUploadTime() {
			return uploadTime;
		}
		public void setUploadTime(String uploadTime) {
			this.uploadTime = uploadTime;
		}
		public String getLastModificationTime() {
			return lastModificationTime;
		}
		public void setLastModificationTime(String lastModificationTime) {
			this.lastModificationTime = lastModificationTime;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public void setAll(int id,String name,String fileFormat,String savingPath,
				String source,String creator,String creatorCompany,
				String creatorAddress,String creatorZipcode,
				String creatorTelephone,String creatorEmail,String recordsNo,
				String fieldsNo,String size,
				String relationalCategory,String metadataDescription,
				String uploader,String uploaderCompany,
				String uploaderAddress,String uploaderZipcode,
				String uploaderTelephone,String uploaderEmail,
				String createTime,String uploadTime,String lastModificationTime,
				String description,int count){
				this.id = id;
				this.name = name;
				this.fileFormat = fileFormat;
				this.savingPath = savingPath;
				this.source = source;
				this.creatorCompany = creatorCompany;
				this.creator = creator;
				this.creatorAddress = creatorAddress;
				this.creatorZipcode = creatorZipcode;
				this.creatorTelephone = creatorTelephone;
				this.creatorEmail = creatorEmail;
				this.recordsNo = recordsNo;
				this.fieldsNo = fieldsNo;
				this.size = size;
				this.relationalCategory = relationalCategory;
				this.metadataDescription = metadataDescription;
				this.uploader = uploader;
				this.uploaderCompany = uploaderCompany;
				this.uploaderAddress = uploaderAddress;
				this.uploaderZipcode = uploaderZipcode;
				this.uploaderTelephone = uploaderTelephone;
				this.uploaderEmail = uploaderEmail;
				this.createTime = createTime;
				this.uploadTime = uploadTime;
				this.lastModificationTime = lastModificationTime;
				this.description = description;
				this.count = count;
				//this.operatingInstruction = operatingInstruction;
		}

		public void setAll(int id,String name,String fileFormat,String savingPath,
				String source,String creator,String creatorCompany,
				String creatorAddress,String creatorZipcode,
				String creatorTelephone,String creatorEmail,String recordsNo,
				String fieldsNo,String size,
				String relationalCategory,String metadataDescription,
				String uploader,String uploaderCompany,
				String uploaderAddress,String uploaderZipcode,
				String uploaderTelephone,String uploaderEmail,
				String createTime,String uploadTime,String lastModificationTime,
				String description){
				this.id = id;
				this.name = name;
				this.fileFormat = fileFormat;
				this.savingPath = savingPath;
				this.source = source;
				this.creatorCompany = creatorCompany;
				this.creator = creator;
				this.creatorAddress = creatorAddress;
				this.creatorZipcode = creatorZipcode;
				this.creatorTelephone = creatorTelephone;
				this.creatorEmail = creatorEmail;
				this.recordsNo = recordsNo;
				this.fieldsNo = fieldsNo;
				this.size = size;
				this.relationalCategory = relationalCategory;
				this.metadataDescription = metadataDescription;
				this.uploader = uploader;
				this.uploaderCompany = uploaderCompany;
				this.uploaderAddress = uploaderAddress;
				this.uploaderZipcode = uploaderZipcode;
				this.uploaderTelephone = uploaderTelephone;
				this.uploaderEmail = uploaderEmail;
				this.createTime = createTime;
				this.uploadTime = uploadTime;
				this.lastModificationTime = lastModificationTime;
				this.description = description;
		}
		public String getFileName()
		{
			String filename = new String();
			if(name != null)
			{
				filename += name;
			}
			if(fileFormat != null && !"".equals(filename))
			{
				filename += ".";
				filename += fileFormat;
			}
			return filename;
			
		}
		
		public String getAbsolutePath()
		{
			String absolutePath = new String();
			if(savingPath != null)
			{
				absolutePath += savingPath;
				absolutePath += "/";
				absolutePath += getFileName();
				return absolutePath;
			}
			return absolutePath;
		}
}
