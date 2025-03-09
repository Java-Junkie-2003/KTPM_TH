
class ConsoleLogger {
    info(message) {
      console.log(`[INFO] ${message}`);
    }
  
    warning(message) {
      console.log(`[WARNING] ${message}`);
    }
  
    error(message) {
      console.log(`[ERROR] ${message}`);
    }
  
    debug(message) {
      console.log(`[DEBUG] ${message}`);
    }
  }
  
  class FileLogger {
    constructor(filePath) {
      this.filePath = filePath;
    }
  
    info(message) {
      this.writeToFile(`[INFO] ${message}`);
    }
  
    warning(message) {
      this.writeToFile(`[WARNING] ${message}`);
    }
  
    error(message) {
      this.writeToFile(`[ERROR] ${message}`);
    }
  
    debug(message) {
      this.writeToFile(`[DEBUG] ${message}`);
    }
  
    writeToFile(message) {

      console.log(`Writing to file ${this.filePath}: ${message}`);
    }
  }
  
  class DatabaseLogger {
    constructor(connectionString) {
      this.connectionString = connectionString;
    }
  
    info(message) {
      this.saveToDatabase(`[INFO] ${message}`);
    }
  
    warning(message) {
      this.saveToDatabase(`[WARNING] ${message}`);
    }
  
    error(message) {
      this.saveToDatabase(`[ERROR] ${message}`);
    }
  
    debug(message) {
      this.saveToDatabase(`[DEBUG] ${message}`);
    }
  
    saveToDatabase(message) {

      console.log(`Saving to database with connection ${this.connectionString}: ${message}`);
    }
  }
  
  class CloudLogger {
    constructor(cloudServiceUrl) {
      this.cloudServiceUrl = cloudServiceUrl;
    }
  
    info(message) {
      this.sendToCloud(`[INFO] ${message}`);
    }
  
    warning(message) {
      this.sendToCloud(`[WARNING] ${message}`);
    }
  
    error(message) {
      this.sendToCloud(`[ERROR] ${message}`);
    }
  
    debug(message) {
      this.sendToCloud(`[DEBUG] ${message}`);
    }
  
    sendToCloud(message) {

      console.log(`Sending to cloud service at ${this.cloudServiceUrl}: ${message}`);
    }
  }
  
  class LoggerFactory {
    static createConsoleLogger() {
      return new ConsoleLogger();
    }
  
    static createFileLogger(filePath) {
      return new FileLogger(filePath);
    }
  
    static createDatabaseLogger(connectionString) {
      return new DatabaseLogger(connectionString);
    }
  
    static createCloudLogger(cloudServiceUrl) {
      return new CloudLogger(cloudServiceUrl);
    }
  }
  
  class LoggerManager {
    constructor() {

      if (LoggerManager.instance) {
        return LoggerManager.instance;
      }
  

      this.loggers = new Map();
      

      this.loggers.set("DEFAULT", LoggerFactory.createConsoleLogger());
      
      LoggerManager.instance = this;
    }
  
    registerLogger(moduleName, logger) {
      this.loggers.set(moduleName, logger);
    }
  
    getLogger(moduleName) {
      if (this.loggers.has(moduleName)) {
        return this.loggers.get(moduleName);
      }
      return this.loggers.get("DEFAULT");
    }
  }
  
  function demoLoggingSystem() {
    const loggerManager = new LoggerManager();
    
    const fileLogger = LoggerFactory.createFileLogger("app_logs.txt");
    const dbLogger = LoggerFactory.createDatabaseLogger("mysql://localhost:3306/logs");
    loggerManager.registerLogger("BOOKING", fileLogger);
    loggerManager.registerLogger("PAYMENT", dbLogger);
  
    
    
    const bookingLogger = loggerManager.getLogger("BOOKING");
    bookingLogger.info("Khách hàng đã đặt xe từ Hà Nội đến Hạ Long");
    bookingLogger.debug("Tìm kiếm tài xế trong bán kính 2km");
    
    const paymentLogger = loggerManager.getLogger("PAYMENT");
    paymentLogger.info("Giao dịch thanh toán #12345 thành công");
    paymentLogger.error("Thanh toán #12346 thất bại: thẻ hết hạn");
    
    const supportLogger = loggerManager.getLogger("CUSTOMER_SUPPORT");
    supportLogger.warning("Khách hàng phàn nàn về tài xế #A123");
    
    const unknownModuleLogger = loggerManager.getLogger("ANALYTICS");
    unknownModuleLogger.info("Đang phân tích dữ liệu chuyến đi");
    
    const anotherLoggerManager = new LoggerManager();  
    console.log("anotherLoggerManager === loggerManager: ", anotherLoggerManager === loggerManager);
  }
  
  demoLoggingSystem();