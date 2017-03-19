 

package edu.tcd.nds.ntwmgmt.infobase;
//--AgentGen BEGIN=_BEGIN
//--AgentGen END

import org.snmp4j.smi.*;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.agent.*;
import org.snmp4j.agent.mo.*;
import org.snmp4j.agent.mo.snmp.*;
import org.snmp4j.agent.mo.snmp.smi.*;
import org.snmp4j.agent.request.*;
import org.snmp4j.log.LogFactory;
import org.snmp4j.log.LogAdapter;
import org.snmp4j.agent.mo.snmp.tc.*;



//--AgentGen BEGIN=_IMPORT
//--AgentGen END

public class HostResourcesMib 
//--AgentGen BEGIN=_EXTENDS
//--AgentGen END
implements MOGroup 
//--AgentGen BEGIN=_IMPLEMENTS
//--AgentGen END
{

  private static final LogAdapter LOGGER = 
      LogFactory.getLogger(HostResourcesMib.class);

//--AgentGen BEGIN=_STATIC
//--AgentGen END

  // Factory
  private MOFactory moFactory = 
    DefaultMOFactory.getInstance();

  // Constants 

  /**
   * OID of this MIB module for usage which can be 
   * used for its identification.
   */
  public static final OID oidHostResourcesMib =
    new OID(new int[] { 1,3,6,1,2,1,25,7,1 });

  // Identities
  // Scalars
  public static final OID oidHrSystemUptime = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,1,0 });
  public static final OID oidHrSystemDate = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,2,0 });
  public static final OID oidHrSystemInitialLoadDevice = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,3,0 });
  public static final OID oidHrSystemInitialLoadParameters = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,4,0 });
  public static final OID oidHrSystemNumUsers = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,5,0 });
  public static final OID oidHrSystemProcesses = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,6,0 });
  public static final OID oidHrSystemMaxProcesses = 
    new OID(new int[] { 1,3,6,1,2,1,25,1,7,0 });
  public static final OID oidHrMemorySize = 
    new OID(new int[] { 1,3,6,1,2,1,25,2,2,0 });
  public static final OID oidHrSWOSIndex = 
    new OID(new int[] { 1,3,6,1,2,1,25,4,1,0 });
  public static final OID oidHrSWInstalledLastChange = 
    new OID(new int[] { 1,3,6,1,2,1,25,6,1,0 });
  public static final OID oidHrSWInstalledLastUpdateTime = 
    new OID(new int[] { 1,3,6,1,2,1,25,6,2,0 });
  // Tables

  // Notifications

  // Enumerations

  public static final class HrDeviceStatusEnum {
    public static final int unknown = 1;
    public static final int running = 2;
    public static final int warning = 3;
    public static final int testing = 4;
    public static final int down = 5;
  }
  public static final class HrPrinterStatusEnum {
    public static final int other = 1;
    public static final int unknown = 2;
    public static final int idle = 3;
    public static final int printing = 4;
    public static final int warmup = 5;
  }
  public static final class HrDiskStorageAccessEnum {
    public static final int readWrite = 1;
    public static final int readOnly = 2;
  }
  public static final class HrDiskStorageMediaEnum {
    public static final int other = 1;
    public static final int unknown = 2;
    public static final int hardDisk = 3;
    public static final int floppyDisk = 4;
    public static final int opticalDiskROM = 5;
    /* -- Write Once Read Many */
    public static final int opticalDiskWORM = 6;
    public static final int opticalDiskRW = 7;
    public static final int ramDisk = 8;
  }
  public static final class HrFSAccessEnum {
    public static final int readWrite = 1;
    public static final int readOnly = 2;
  }
  public static final class HrSWRunTypeEnum {
    public static final int unknown = 1;
    public static final int operatingSystem = 2;
    public static final int deviceDriver = 3;
    public static final int application = 4;
  }
  public static final class HrSWRunStatusEnum {
    public static final int running = 1;
    /* -- waiting for resource
-- (i.e., CPU, memory, IO) */
    public static final int runnable = 2;
    /* -- loaded but waiting for event */
    public static final int notRunnable = 3;
    /* -- not loaded */
    public static final int invalid = 4;
  }
  public static final class HrSWInstalledTypeEnum {
    public static final int unknown = 1;
    public static final int operatingSystem = 2;
    public static final int deviceDriver = 3;
    public static final int application = 4;
  }



  // TextualConventions
  private static final String TC_MODULE_SNMPV2_TC = "SNMPv2-TC";
  private static final String TC_MODULE_IF_MIB = "IF-MIB";
  private static final String TC_MODULE_HOST_RESOURCES_MIB = "HOST-RESOURCES-MIB";
  private static final String TC_INTERNATIONALDISPLAYSTRING = "InternationalDisplayString";
  private static final String TC_KBYTES = "KBytes";
  private static final String TC_AUTONOMOUSTYPE = "AutonomousType";
  private static final String TC_DISPLAYSTRING = "DisplayString";
  private static final String TC_TRUTHVALUE = "TruthValue";
  private static final String TC_DATEANDTIME = "DateAndTime";
  private static final String TC_PRODUCTID = "ProductID";
  private static final String TC_INTERFACEINDEXORZERO = "InterfaceIndexOrZero";

  // Scalars
  private MOScalar hrSystemUptime;
  private MOScalar hrSystemDate;
  private MOScalar hrSystemInitialLoadDevice;
  private MOScalar hrSystemInitialLoadParameters;
  private MOScalar hrSystemNumUsers;
  private MOScalar hrSystemProcesses;
  private MOScalar hrSystemMaxProcesses;
  private MOScalar hrMemorySize;
  private MOScalar hrSWOSIndex;
  private MOScalar hrSWInstalledLastChange;
  private MOScalar hrSWInstalledLastUpdateTime;

  // Tables
  public static final OID oidHrStorageEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,2,3,1 });

  // Index OID definitions
  public static final OID oidHrStorageIndex =
    new OID(new int[] { 1,3,6,1,2,1,25,2,3,1,1 });

  // Column TC definitions for hrStorageEntry:
  public static final String tcModuleSNMPv2Tc = "SNMPv2-TC";
  public static final String tcDefAutonomousType = "AutonomousType";
  public static final String tcDefDisplayString = "DisplayString";
    
  // Column sub-identifier definitions for hrStorageEntry:
  public static final int colHrStorageIndex = 1;
  public static final int colHrStorageType = 2;
  public static final int colHrStorageDescr = 3;
  public static final int colHrStorageAllocationUnits = 4;
  public static final int colHrStorageSize = 5;
  public static final int colHrStorageUsed = 6;
  public static final int colHrStorageAllocationFailures = 7;

  // Column index definitions for hrStorageEntry:
  public static final int idxHrStorageIndex = 0;
  public static final int idxHrStorageType = 1;
  public static final int idxHrStorageDescr = 2;
  public static final int idxHrStorageAllocationUnits = 3;
  public static final int idxHrStorageSize = 4;
  public static final int idxHrStorageUsed = 5;
  public static final int idxHrStorageAllocationFailures = 6;

  private MOTableSubIndex[] hrStorageEntryIndexes;
  private MOTableIndex hrStorageEntryIndex;
  
  private MOTable hrStorageEntry;
  private MOTableModel hrStorageEntryModel;
  public static final OID oidHrDeviceEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,2,1 });

  // Index OID definitions
  public static final OID oidHrDeviceIndex =
    new OID(new int[] { 1,3,6,1,2,1,25,3,2,1,1 });

  // Column TC definitions for hrDeviceEntry:
  public static final String tcModuleHostResourcesMib = "HOST-RESOURCES-MIB";
  public static final String tcDefProductID = "ProductID";
    
  // Column sub-identifier definitions for hrDeviceEntry:
  public static final int colHrDeviceIndex = 1;
  public static final int colHrDeviceType = 2;
  public static final int colHrDeviceDescr = 3;
  public static final int colHrDeviceID = 4;
  public static final int colHrDeviceStatus = 5;
  public static final int colHrDeviceErrors = 6;

  // Column index definitions for hrDeviceEntry:
  public static final int idxHrDeviceIndex = 0;
  public static final int idxHrDeviceType = 1;
  public static final int idxHrDeviceDescr = 2;
  public static final int idxHrDeviceID = 3;
  public static final int idxHrDeviceStatus = 4;
  public static final int idxHrDeviceErrors = 5;

  private MOTableSubIndex[] hrDeviceEntryIndexes;
  private MOTableIndex hrDeviceEntryIndex;
  
  private MOTable hrDeviceEntry;
  private MOTableModel hrDeviceEntryModel;
  public static final OID oidHrProcessorEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,3,1 });

  // Index OID definitions
  //public static final OID oidHrDeviceIndex =
  //  new OID(new int[] { 1,3,6,1,2,1,25,3,2,1,1 });

  // Column TC definitions for hrProcessorEntry:
    
  // Column sub-identifier definitions for hrProcessorEntry:
  public static final int colHrProcessorFrwID = 1;
  public static final int colHrProcessorLoad = 2;

  // Column index definitions for hrProcessorEntry:
  public static final int idxHrProcessorFrwID = 0;
  public static final int idxHrProcessorLoad = 1;

  private MOTableSubIndex[] hrProcessorEntryIndexes;
  private MOTableIndex hrProcessorEntryIndex;
  
  private MOTable hrProcessorEntry;
  private MOTableModel hrProcessorEntryModel;
  public static final OID oidHrNetworkEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,4,1 });

  // Index OID definitions
  //public static final OID oidHrDeviceIndex =
  //  new OID(new int[] { 1,3,6,1,2,1,25,3,2,1,1 });

  // Column TC definitions for hrNetworkEntry:
  public static final String tcModuleIfMib = "IF-MIB";
  public static final String tcDefInterfaceIndexOrZero = "InterfaceIndexOrZero";
    
  // Column sub-identifier definitions for hrNetworkEntry:
  public static final int colHrNetworkIfIndex = 1;

  // Column index definitions for hrNetworkEntry:
  public static final int idxHrNetworkIfIndex = 0;

  private MOTableSubIndex[] hrNetworkEntryIndexes;
  private MOTableIndex hrNetworkEntryIndex;
  
  private MOTable hrNetworkEntry;
  private MOTableModel hrNetworkEntryModel;
  public static final OID oidHrPrinterEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,5,1 });

  // Index OID definitions
  //public static final OID oidHrDeviceIndex =
  //  new OID(new int[] { 1,3,6,1,2,1,25,3,2,1,1 });

  // Column TC definitions for hrPrinterEntry:
    
  // Column sub-identifier definitions for hrPrinterEntry:
  public static final int colHrPrinterStatus = 1;
  public static final int colHrPrinterDetectedErrorState = 2;

  // Column index definitions for hrPrinterEntry:
  public static final int idxHrPrinterStatus = 0;
  public static final int idxHrPrinterDetectedErrorState = 1;

  private MOTableSubIndex[] hrPrinterEntryIndexes;
  private MOTableIndex hrPrinterEntryIndex;
  
  private MOTable hrPrinterEntry;
  private MOTableModel hrPrinterEntryModel;
  public static final OID oidHrDiskStorageEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,6,1 });

  // Index OID definitions
  //public static final OID oidHrDeviceIndex =
  //  new OID(new int[] { 1,3,6,1,2,1,25,3,2,1,1 });

  // Column TC definitions for hrDiskStorageEntry:
  public static final String tcDefTruthValue = "TruthValue";
  public static final String tcDefKBytes = "KBytes";
    
  // Column sub-identifier definitions for hrDiskStorageEntry:
  public static final int colHrDiskStorageAccess = 1;
  public static final int colHrDiskStorageMedia = 2;
  public static final int colHrDiskStorageRemoveble = 3;
  public static final int colHrDiskStorageCapacity = 4;

  // Column index definitions for hrDiskStorageEntry:
  public static final int idxHrDiskStorageAccess = 0;
  public static final int idxHrDiskStorageMedia = 1;
  public static final int idxHrDiskStorageRemoveble = 2;
  public static final int idxHrDiskStorageCapacity = 3;

  private MOTableSubIndex[] hrDiskStorageEntryIndexes;
  private MOTableIndex hrDiskStorageEntryIndex;
  
  private MOTable hrDiskStorageEntry;
  private MOTableModel hrDiskStorageEntryModel;
  public static final OID oidHrPartitionEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,7,1 });

  // Index OID definitions
  //public static final OID oidHrDeviceIndex =
  //  new OID(new int[] { 1,3,6,1,2,1,25,3,2,1,1 });
  public static final OID oidHrPartitionIndex =
    new OID(new int[] { 1,3,6,1,2,1,25,3,7,1,1 });

  // Column TC definitions for hrPartitionEntry:
  public static final String tcDefInternationalDisplayString = "InternationalDisplayString";
    
  // Column sub-identifier definitions for hrPartitionEntry:
  public static final int colHrPartitionIndex = 1;
  public static final int colHrPartitionLabel = 2;
  public static final int colHrPartitionID = 3;
  public static final int colHrPartitionSize = 4;
  public static final int colHrPartitionFSIndex = 5;

  // Column index definitions for hrPartitionEntry:
  public static final int idxHrPartitionIndex = 0;
  public static final int idxHrPartitionLabel = 1;
  public static final int idxHrPartitionID = 2;
  public static final int idxHrPartitionSize = 3;
  public static final int idxHrPartitionFSIndex = 4;

  private MOTableSubIndex[] hrPartitionEntryIndexes;
  private MOTableIndex hrPartitionEntryIndex;
  
  private MOTable hrPartitionEntry;
  private MOTableModel hrPartitionEntryModel;
  public static final OID oidHrFSEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,3,8,1 });

  // Index OID definitions
  public static final OID oidHrFSIndex =
    new OID(new int[] { 1,3,6,1,2,1,25,3,8,1,1 });

  // Column TC definitions for hrFSEntry:
  public static final String tcDefDateAndTime = "DateAndTime";
    
  // Column sub-identifier definitions for hrFSEntry:
  public static final int colHrFSIndex = 1;
  public static final int colHrFSMountPoint = 2;
  public static final int colHrFSRemoteMountPoint = 3;
  public static final int colHrFSType = 4;
  public static final int colHrFSAccess = 5;
  public static final int colHrFSBootable = 6;
  public static final int colHrFSStorageIndex = 7;
  public static final int colHrFSLastFullBackupDate = 8;
  public static final int colHrFSLastPartialBackupDate = 9;

  // Column index definitions for hrFSEntry:
  public static final int idxHrFSIndex = 0;
  public static final int idxHrFSMountPoint = 1;
  public static final int idxHrFSRemoteMountPoint = 2;
  public static final int idxHrFSType = 3;
  public static final int idxHrFSAccess = 4;
  public static final int idxHrFSBootable = 5;
  public static final int idxHrFSStorageIndex = 6;
  public static final int idxHrFSLastFullBackupDate = 7;
  public static final int idxHrFSLastPartialBackupDate = 8;

  private MOTableSubIndex[] hrFSEntryIndexes;
  private MOTableIndex hrFSEntryIndex;
  
  private MOTable hrFSEntry;
  private MOTableModel hrFSEntryModel;
  public static final OID oidHrSWRunEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,4,2,1 });

  // Index OID definitions
  public static final OID oidHrSWRunIndex =
    new OID(new int[] { 1,3,6,1,2,1,25,4,2,1,1 });

  // Column TC definitions for hrSWRunEntry:
    
  // Column sub-identifier definitions for hrSWRunEntry:
  public static final int colHrSWRunIndex = 1;
  public static final int colHrSWRunName = 2;
  public static final int colHrSWRunID = 3;
  public static final int colHrSWRunPath = 4;
  public static final int colHrSWRunParameters = 5;
  public static final int colHrSWRunType = 6;
  public static final int colHrSWRunStatus = 7;

  // Column index definitions for hrSWRunEntry:
  public static final int idxHrSWRunIndex = 0;
  public static final int idxHrSWRunName = 1;
  public static final int idxHrSWRunID = 2;
  public static final int idxHrSWRunPath = 3;
  public static final int idxHrSWRunParameters = 4;
  public static final int idxHrSWRunType = 5;
  public static final int idxHrSWRunStatus = 6;

  private MOTableSubIndex[] hrSWRunEntryIndexes;
  private MOTableIndex hrSWRunEntryIndex;
  
  private MOTable hrSWRunEntry;
  private MOTableModel hrSWRunEntryModel;
  public static final OID oidHrSWRunPerfEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,5,1,1 });

  // Index OID definitions
  //public static final OID oidHrSWRunIndex =
  //  new OID(new int[] { 1,3,6,1,2,1,25,4,2,1,1 });

  // Column TC definitions for hrSWRunPerfEntry:
    
  // Column sub-identifier definitions for hrSWRunPerfEntry:
  public static final int colHrSWRunPerfCPU = 1;
  public static final int colHrSWRunPerfMem = 2;

  // Column index definitions for hrSWRunPerfEntry:
  public static final int idxHrSWRunPerfCPU = 0;
  public static final int idxHrSWRunPerfMem = 1;

  private MOTableSubIndex[] hrSWRunPerfEntryIndexes;
  private MOTableIndex hrSWRunPerfEntryIndex;
  
  private MOTable hrSWRunPerfEntry;
  private MOTableModel hrSWRunPerfEntryModel;
  public static final OID oidHrSWInstalledEntry = 
    new OID(new int[] { 1,3,6,1,2,1,25,6,3,1 });

  // Index OID definitions
  public static final OID oidHrSWInstalledIndex =
    new OID(new int[] { 1,3,6,1,2,1,25,6,3,1,1 });

  // Column TC definitions for hrSWInstalledEntry:
    
  // Column sub-identifier definitions for hrSWInstalledEntry:
  public static final int colHrSWInstalledIndex = 1;
  public static final int colHrSWInstalledName = 2;
  public static final int colHrSWInstalledID = 3;
  public static final int colHrSWInstalledType = 4;
  public static final int colHrSWInstalledDate = 5;

  // Column index definitions for hrSWInstalledEntry:
  public static final int idxHrSWInstalledIndex = 0;
  public static final int idxHrSWInstalledName = 1;
  public static final int idxHrSWInstalledID = 2;
  public static final int idxHrSWInstalledType = 3;
  public static final int idxHrSWInstalledDate = 4;

  private MOTableSubIndex[] hrSWInstalledEntryIndexes;
  private MOTableIndex hrSWInstalledEntryIndex;
  
  private MOTable hrSWInstalledEntry;
  private MOTableModel hrSWInstalledEntryModel;


//--AgentGen BEGIN=_MEMBERS
//--AgentGen END

  /**
   * Constructs a HostResourcesMib instance without actually creating its
   * <code>ManagedObject</code> instances. This has to be done in a
   * sub-class constructor or after construction by calling 
   * {@link #createMO(MOFactory moFactory)}. 
   */
  protected HostResourcesMib() {
//--AgentGen BEGIN=_DEFAULTCONSTRUCTOR
//--AgentGen END
  }

  /**
   * Constructs a HostResourcesMib instance and actually creates its
   * <code>ManagedObject</code> instances using the supplied 
   * <code>MOFactory</code> (by calling
   * {@link #createMO(MOFactory moFactory)}).
   * @param moFactory
   *    the <code>MOFactory</code> to be used to create the
   *    managed objects for this module.
   */
  public HostResourcesMib(MOFactory moFactory) {
  	this();
    createMO(moFactory);
//--AgentGen BEGIN=_FACTORYCONSTRUCTOR
//--AgentGen END
  }

//--AgentGen BEGIN=_CONSTRUCTORS
//--AgentGen END

  /**
   * Create the ManagedObjects defined for this MIB module
   * using the specified {@link MOFactory}.
   * @param moFactory
   *    the <code>MOFactory</code> instance to use for object 
   *    creation.
   */
  protected void createMO(MOFactory moFactory) {
    addTCsToFactory(moFactory);
    hrSystemUptime = 
      moFactory.createScalar(oidHrSystemUptime,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new TimeTicks());
    hrSystemDate = 
      new HrSystemDate(oidHrSystemDate, 
                       moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE));
    hrSystemDate.addMOValueValidationListener(new HrSystemDateValidator());
    hrSystemInitialLoadDevice = 
      new HrSystemInitialLoadDevice(oidHrSystemInitialLoadDevice, 
                                    moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE));
    hrSystemInitialLoadDevice.addMOValueValidationListener(new HrSystemInitialLoadDeviceValidator());
    hrSystemInitialLoadParameters = 
      new HrSystemInitialLoadParameters(oidHrSystemInitialLoadParameters, 
                                        moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE));
    hrSystemInitialLoadParameters.addMOValueValidationListener(new HrSystemInitialLoadParametersValidator());
    hrSystemNumUsers = 
      moFactory.createScalar(oidHrSystemNumUsers,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Gauge32());
    hrSystemProcesses = 
      moFactory.createScalar(oidHrSystemProcesses,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Gauge32());
    hrSystemMaxProcesses = 
      moFactory.createScalar(oidHrSystemMaxProcesses,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Integer32());
    hrMemorySize = 
      moFactory.createScalar(oidHrMemorySize,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             null,
                             TC_MODULE_HOST_RESOURCES_MIB, TC_KBYTES);
    hrSWOSIndex = 
      moFactory.createScalar(oidHrSWOSIndex,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new Integer32());
    hrSWInstalledLastChange = 
      moFactory.createScalar(oidHrSWInstalledLastChange,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new TimeTicks());
    hrSWInstalledLastUpdateTime = 
      moFactory.createScalar(oidHrSWInstalledLastUpdateTime,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY), 
                             new TimeTicks());
    createHrStorageEntry(moFactory);
    createHrDeviceEntry(moFactory);
    createHrProcessorEntry(moFactory);
    createHrNetworkEntry(moFactory);
    createHrPrinterEntry(moFactory);
    createHrDiskStorageEntry(moFactory);
    createHrPartitionEntry(moFactory);
    createHrFSEntry(moFactory);
    createHrSWRunEntry(moFactory);
    createHrSWRunPerfEntry(moFactory);
    createHrSWInstalledEntry(moFactory);
  }

  public MOScalar getHrSystemUptime() {
    return hrSystemUptime;
  }
  public MOScalar getHrSystemDate() {
    return hrSystemDate;
  }
  public MOScalar getHrSystemInitialLoadDevice() {
    return hrSystemInitialLoadDevice;
  }
  public MOScalar getHrSystemInitialLoadParameters() {
    return hrSystemInitialLoadParameters;
  }
  public MOScalar getHrSystemNumUsers() {
    return hrSystemNumUsers;
  }
  public MOScalar getHrSystemProcesses() {
    return hrSystemProcesses;
  }
  public MOScalar getHrSystemMaxProcesses() {
    return hrSystemMaxProcesses;
  }
  public MOScalar getHrMemorySize() {
    return hrMemorySize;
  }
  public MOScalar getHrSWOSIndex() {
    return hrSWOSIndex;
  }
  public MOScalar getHrSWInstalledLastChange() {
    return hrSWInstalledLastChange;
  }
  public MOScalar getHrSWInstalledLastUpdateTime() {
    return hrSWInstalledLastUpdateTime;
  }


  public MOTable getHrStorageEntry() {
    return hrStorageEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrStorageEntry(MOFactory moFactory) {
    // Index definition
    hrStorageEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrStorageIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrStorageEntryIndex = 
      moFactory.createIndex(hrStorageEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrStorageEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrStorageEntryColumns = new MOColumn[7];
    hrStorageEntryColumns[idxHrStorageIndex] = 
      moFactory.createColumn(colHrStorageIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrStorageEntryColumns[idxHrStorageType] = 
      moFactory.createColumn(colHrStorageType, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefAutonomousType);
    hrStorageEntryColumns[idxHrStorageDescr] = 
      moFactory.createColumn(colHrStorageDescr, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefDisplayString);
    hrStorageEntryColumns[idxHrStorageAllocationUnits] = 
      moFactory.createColumn(colHrStorageAllocationUnits, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrStorageEntryColumns[idxHrStorageSize] = 
      new MOMutableColumn(colHrStorageSize,
                          SMIConstants.SYNTAX_INTEGER32,
                          moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                          (Integer32)null);
    ValueConstraint hrStorageSizeVC = new ConstraintsImpl();
    ((ConstraintsImpl)hrStorageSizeVC).add(new Constraint(0L, 2147483647L));
    ((MOMutableColumn)hrStorageEntryColumns[idxHrStorageSize]).
      addMOValueValidationListener(new ValueConstraintValidator(hrStorageSizeVC));                                  
    ((MOMutableColumn)hrStorageEntryColumns[idxHrStorageSize]).
      addMOValueValidationListener(new HrStorageSizeValidator());
    hrStorageEntryColumns[idxHrStorageUsed] = 
      moFactory.createColumn(colHrStorageUsed, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrStorageEntryColumns[idxHrStorageAllocationFailures] = 
      moFactory.createColumn(colHrStorageAllocationFailures, 
                             SMIConstants.SYNTAX_COUNTER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    // Table model
    hrStorageEntryModel = 
      moFactory.createTableModel(oidHrStorageEntry,
                                 hrStorageEntryIndex,
                                 hrStorageEntryColumns);
    ((MOMutableTableModel)hrStorageEntryModel).setRowFactory(
      new HrStorageEntryRowFactory());
    hrStorageEntry = 
      moFactory.createTable(oidHrStorageEntry,
                            hrStorageEntryIndex,
                            hrStorageEntryColumns,
                            hrStorageEntryModel);
  }

  public MOTable getHrDeviceEntry() {
    return hrDeviceEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrDeviceEntry(MOFactory moFactory) {
    // Index definition
    hrDeviceEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrDeviceIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrDeviceEntryIndex = 
      moFactory.createIndex(hrDeviceEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrDeviceEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrDeviceEntryColumns = new MOColumn[6];
    hrDeviceEntryColumns[idxHrDeviceIndex] = 
      moFactory.createColumn(colHrDeviceIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrDeviceEntryColumns[idxHrDeviceType] = 
      moFactory.createColumn(colHrDeviceType, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefAutonomousType);
    hrDeviceEntryColumns[idxHrDeviceDescr] = 
      moFactory.createColumn(colHrDeviceDescr, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefDisplayString);
    hrDeviceEntryColumns[idxHrDeviceID] = 
      moFactory.createColumn(colHrDeviceID, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefProductID);
    hrDeviceEntryColumns[idxHrDeviceStatus] = 
      moFactory.createColumn(colHrDeviceStatus, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrDeviceEntryColumns[idxHrDeviceErrors] = 
      moFactory.createColumn(colHrDeviceErrors, 
                             SMIConstants.SYNTAX_COUNTER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    // Table model
    hrDeviceEntryModel = 
      moFactory.createTableModel(oidHrDeviceEntry,
                                 hrDeviceEntryIndex,
                                 hrDeviceEntryColumns);
    ((MOMutableTableModel)hrDeviceEntryModel).setRowFactory(
      new HrDeviceEntryRowFactory());
    hrDeviceEntry = 
      moFactory.createTable(oidHrDeviceEntry,
                            hrDeviceEntryIndex,
                            hrDeviceEntryColumns,
                            hrDeviceEntryModel);
  }

  public MOTable getHrProcessorEntry() {
    return hrProcessorEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrProcessorEntry(MOFactory moFactory) {
    // Index definition
    hrProcessorEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrDeviceIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrProcessorEntryIndex = 
      moFactory.createIndex(hrProcessorEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrProcessorEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrProcessorEntryColumns = new MOColumn[2];
    hrProcessorEntryColumns[idxHrProcessorFrwID] = 
      moFactory.createColumn(colHrProcessorFrwID, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefProductID);
    hrProcessorEntryColumns[idxHrProcessorLoad] = 
      moFactory.createColumn(colHrProcessorLoad, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    // Table model
    hrProcessorEntryModel = 
      moFactory.createTableModel(oidHrProcessorEntry,
                                 hrProcessorEntryIndex,
                                 hrProcessorEntryColumns);
    ((MOMutableTableModel)hrProcessorEntryModel).setRowFactory(
      new HrProcessorEntryRowFactory());
    hrProcessorEntry = 
      moFactory.createTable(oidHrProcessorEntry,
                            hrProcessorEntryIndex,
                            hrProcessorEntryColumns,
                            hrProcessorEntryModel);
  }

  public MOTable getHrNetworkEntry() {
    return hrNetworkEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrNetworkEntry(MOFactory moFactory) {
    // Index definition
    hrNetworkEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrDeviceIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrNetworkEntryIndex = 
      moFactory.createIndex(hrNetworkEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrNetworkEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrNetworkEntryColumns = new MOColumn[1];
    hrNetworkEntryColumns[idxHrNetworkIfIndex] = 
      moFactory.createColumn(colHrNetworkIfIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleIfMib,
                             tcDefInterfaceIndexOrZero);
    // Table model
    hrNetworkEntryModel = 
      moFactory.createTableModel(oidHrNetworkEntry,
                                 hrNetworkEntryIndex,
                                 hrNetworkEntryColumns);
    ((MOMutableTableModel)hrNetworkEntryModel).setRowFactory(
      new HrNetworkEntryRowFactory());
    hrNetworkEntry = 
      moFactory.createTable(oidHrNetworkEntry,
                            hrNetworkEntryIndex,
                            hrNetworkEntryColumns,
                            hrNetworkEntryModel);
  }

  public MOTable getHrPrinterEntry() {
    return hrPrinterEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrPrinterEntry(MOFactory moFactory) {
    // Index definition
    hrPrinterEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrDeviceIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrPrinterEntryIndex = 
      moFactory.createIndex(hrPrinterEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrPrinterEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrPrinterEntryColumns = new MOColumn[2];
    hrPrinterEntryColumns[idxHrPrinterStatus] = 
      moFactory.createColumn(colHrPrinterStatus, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrPrinterEntryColumns[idxHrPrinterDetectedErrorState] = 
      moFactory.createColumn(colHrPrinterDetectedErrorState, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    // Table model
    hrPrinterEntryModel = 
      moFactory.createTableModel(oidHrPrinterEntry,
                                 hrPrinterEntryIndex,
                                 hrPrinterEntryColumns);
    ((MOMutableTableModel)hrPrinterEntryModel).setRowFactory(
      new HrPrinterEntryRowFactory());
    hrPrinterEntry = 
      moFactory.createTable(oidHrPrinterEntry,
                            hrPrinterEntryIndex,
                            hrPrinterEntryColumns,
                            hrPrinterEntryModel);
  }

  public MOTable getHrDiskStorageEntry() {
    return hrDiskStorageEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrDiskStorageEntry(MOFactory moFactory) {
    // Index definition
    hrDiskStorageEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrDeviceIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrDiskStorageEntryIndex = 
      moFactory.createIndex(hrDiskStorageEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrDiskStorageEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrDiskStorageEntryColumns = new MOColumn[4];
    hrDiskStorageEntryColumns[idxHrDiskStorageAccess] = 
      moFactory.createColumn(colHrDiskStorageAccess, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrDiskStorageEntryColumns[idxHrDiskStorageMedia] = 
      moFactory.createColumn(colHrDiskStorageMedia, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrDiskStorageEntryColumns[idxHrDiskStorageRemoveble] = 
      moFactory.createColumn(colHrDiskStorageRemoveble, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefTruthValue);
    hrDiskStorageEntryColumns[idxHrDiskStorageCapacity] = 
      moFactory.createColumn(colHrDiskStorageCapacity, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefKBytes);
    // Table model
    hrDiskStorageEntryModel = 
      moFactory.createTableModel(oidHrDiskStorageEntry,
                                 hrDiskStorageEntryIndex,
                                 hrDiskStorageEntryColumns);
    ((MOMutableTableModel)hrDiskStorageEntryModel).setRowFactory(
      new HrDiskStorageEntryRowFactory());
    hrDiskStorageEntry = 
      moFactory.createTable(oidHrDiskStorageEntry,
                            hrDiskStorageEntryIndex,
                            hrDiskStorageEntryColumns,
                            hrDiskStorageEntryModel);
  }

  public MOTable getHrPartitionEntry() {
    return hrPartitionEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrPartitionEntry(MOFactory moFactory) {
    // Index definition
    hrPartitionEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrDeviceIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1),
      moFactory.createSubIndex(oidHrPartitionIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrPartitionEntryIndex = 
      moFactory.createIndex(hrPartitionEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrPartitionEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrPartitionEntryColumns = new MOColumn[5];
    hrPartitionEntryColumns[idxHrPartitionIndex] = 
      moFactory.createColumn(colHrPartitionIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrPartitionEntryColumns[idxHrPartitionLabel] = 
      moFactory.createColumn(colHrPartitionLabel, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrPartitionEntryColumns[idxHrPartitionID] = 
      moFactory.createColumn(colHrPartitionID, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrPartitionEntryColumns[idxHrPartitionSize] = 
      moFactory.createColumn(colHrPartitionSize, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefKBytes);
    hrPartitionEntryColumns[idxHrPartitionFSIndex] = 
      moFactory.createColumn(colHrPartitionFSIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    // Table model
    hrPartitionEntryModel = 
      moFactory.createTableModel(oidHrPartitionEntry,
                                 hrPartitionEntryIndex,
                                 hrPartitionEntryColumns);
    ((MOMutableTableModel)hrPartitionEntryModel).setRowFactory(
      new HrPartitionEntryRowFactory());
    hrPartitionEntry = 
      moFactory.createTable(oidHrPartitionEntry,
                            hrPartitionEntryIndex,
                            hrPartitionEntryColumns,
                            hrPartitionEntryModel);
  }

  public MOTable getHrFSEntry() {
    return hrFSEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrFSEntry(MOFactory moFactory) {
    // Index definition
    hrFSEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrFSIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrFSEntryIndex = 
      moFactory.createIndex(hrFSEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrFSEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrFSEntryColumns = new MOColumn[9];
    hrFSEntryColumns[idxHrFSIndex] = 
      moFactory.createColumn(colHrFSIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrFSEntryColumns[idxHrFSMountPoint] = 
      moFactory.createColumn(colHrFSMountPoint, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrFSEntryColumns[idxHrFSRemoteMountPoint] = 
      moFactory.createColumn(colHrFSRemoteMountPoint, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrFSEntryColumns[idxHrFSType] = 
      moFactory.createColumn(colHrFSType, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefAutonomousType);
    hrFSEntryColumns[idxHrFSAccess] = 
      moFactory.createColumn(colHrFSAccess, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrFSEntryColumns[idxHrFSBootable] = 
      moFactory.createColumn(colHrFSBootable, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefTruthValue);
    hrFSEntryColumns[idxHrFSStorageIndex] = 
      moFactory.createColumn(colHrFSStorageIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrFSEntryColumns[idxHrFSLastFullBackupDate] = 
      new DateAndTime(colHrFSLastFullBackupDate,
                      moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                      (OctetString)null);
    ValueConstraint hrFSLastFullBackupDateVC = new ConstraintsImpl();
    ((ConstraintsImpl)hrFSLastFullBackupDateVC).add(new Constraint(8L, 8L));
    ((ConstraintsImpl)hrFSLastFullBackupDateVC).add(new Constraint(11L, 11L));
    ((MOMutableColumn)hrFSEntryColumns[idxHrFSLastFullBackupDate]).
      addMOValueValidationListener(new ValueConstraintValidator(hrFSLastFullBackupDateVC));                                  
    ((MOMutableColumn)hrFSEntryColumns[idxHrFSLastFullBackupDate]).
      addMOValueValidationListener(new HrFSLastFullBackupDateValidator());
    hrFSEntryColumns[idxHrFSLastPartialBackupDate] = 
      new DateAndTime(colHrFSLastPartialBackupDate,
                      moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE),
                      (OctetString)null);
    ValueConstraint hrFSLastPartialBackupDateVC = new ConstraintsImpl();
    ((ConstraintsImpl)hrFSLastPartialBackupDateVC).add(new Constraint(8L, 8L));
    ((ConstraintsImpl)hrFSLastPartialBackupDateVC).add(new Constraint(11L, 11L));
    ((MOMutableColumn)hrFSEntryColumns[idxHrFSLastPartialBackupDate]).
      addMOValueValidationListener(new ValueConstraintValidator(hrFSLastPartialBackupDateVC));                                  
    ((MOMutableColumn)hrFSEntryColumns[idxHrFSLastPartialBackupDate]).
      addMOValueValidationListener(new HrFSLastPartialBackupDateValidator());
    // Table model
    hrFSEntryModel = 
      moFactory.createTableModel(oidHrFSEntry,
                                 hrFSEntryIndex,
                                 hrFSEntryColumns);
    ((MOMutableTableModel)hrFSEntryModel).setRowFactory(
      new HrFSEntryRowFactory());
    hrFSEntry = 
      moFactory.createTable(oidHrFSEntry,
                            hrFSEntryIndex,
                            hrFSEntryColumns,
                            hrFSEntryModel);
  }

  public MOTable getHrSWRunEntry() {
    return hrSWRunEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrSWRunEntry(MOFactory moFactory) {
    // Index definition
    hrSWRunEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrSWRunIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrSWRunEntryIndex = 
      moFactory.createIndex(hrSWRunEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrSWRunEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrSWRunEntryColumns = new MOColumn[7];
    hrSWRunEntryColumns[idxHrSWRunIndex] = 
      moFactory.createColumn(colHrSWRunIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrSWRunEntryColumns[idxHrSWRunName] = 
      moFactory.createColumn(colHrSWRunName, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrSWRunEntryColumns[idxHrSWRunID] = 
      moFactory.createColumn(colHrSWRunID, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefProductID);
    hrSWRunEntryColumns[idxHrSWRunPath] = 
      moFactory.createColumn(colHrSWRunPath, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrSWRunEntryColumns[idxHrSWRunParameters] = 
      moFactory.createColumn(colHrSWRunParameters, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrSWRunEntryColumns[idxHrSWRunType] = 
      moFactory.createColumn(colHrSWRunType, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrSWRunEntryColumns[idxHrSWRunStatus] = new Enumerated(colHrSWRunStatus, moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_WRITE), (Integer32)null);
    ValueConstraint hrSWRunStatusVC = new EnumerationConstraint(
      new int[] { HrSWRunStatusEnum.running,
                  HrSWRunStatusEnum.runnable,
                  HrSWRunStatusEnum.notRunnable,
                  HrSWRunStatusEnum.invalid });
    ((MOMutableColumn)hrSWRunEntryColumns[idxHrSWRunStatus]).
      addMOValueValidationListener(new ValueConstraintValidator(hrSWRunStatusVC));                                  
    ((MOMutableColumn)hrSWRunEntryColumns[idxHrSWRunStatus]).
      addMOValueValidationListener(new HrSWRunStatusValidator());
    // Table model
    hrSWRunEntryModel = 
      moFactory.createTableModel(oidHrSWRunEntry,
                                 hrSWRunEntryIndex,
                                 hrSWRunEntryColumns);
    ((MOMutableTableModel)hrSWRunEntryModel).setRowFactory(
      new HrSWRunEntryRowFactory());
    hrSWRunEntry = 
      moFactory.createTable(oidHrSWRunEntry,
                            hrSWRunEntryIndex,
                            hrSWRunEntryColumns,
                            hrSWRunEntryModel);
  }

  public MOTable getHrSWRunPerfEntry() {
    return hrSWRunPerfEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrSWRunPerfEntry(MOFactory moFactory) {
    // Index definition
    hrSWRunPerfEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrSWRunIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrSWRunPerfEntryIndex = 
      moFactory.createIndex(hrSWRunPerfEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrSWRunPerfEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrSWRunPerfEntryColumns = new MOColumn[2];
    hrSWRunPerfEntryColumns[idxHrSWRunPerfCPU] = 
      moFactory.createColumn(colHrSWRunPerfCPU, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrSWRunPerfEntryColumns[idxHrSWRunPerfMem] = 
      moFactory.createColumn(colHrSWRunPerfMem, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefKBytes);
    // Table model
    hrSWRunPerfEntryModel = 
      moFactory.createTableModel(oidHrSWRunPerfEntry,
                                 hrSWRunPerfEntryIndex,
                                 hrSWRunPerfEntryColumns);
    ((MOMutableTableModel)hrSWRunPerfEntryModel).setRowFactory(
      new HrSWRunPerfEntryRowFactory());
    hrSWRunPerfEntry = 
      moFactory.createTable(oidHrSWRunPerfEntry,
                            hrSWRunPerfEntryIndex,
                            hrSWRunPerfEntryColumns,
                            hrSWRunPerfEntryModel);
  }

  public MOTable getHrSWInstalledEntry() {
    return hrSWInstalledEntry;
  }


  @SuppressWarnings(value={"unchecked"})
  private void createHrSWInstalledEntry(MOFactory moFactory) {
    // Index definition
    hrSWInstalledEntryIndexes = 
      new MOTableSubIndex[] {
      moFactory.createSubIndex(oidHrSWInstalledIndex, 
                               SMIConstants.SYNTAX_INTEGER, 1, 1)    };

    hrSWInstalledEntryIndex = 
      moFactory.createIndex(hrSWInstalledEntryIndexes,
                            false,
                            new MOTableIndexValidator() {
      public boolean isValidIndex(OID index) {
        boolean isValidIndex = true;
     //--AgentGen BEGIN=hrSWInstalledEntry::isValidIndex
     //--AgentGen END
        return isValidIndex;
      }
    });

    // Columns
    MOColumn[] hrSWInstalledEntryColumns = new MOColumn[5];
    hrSWInstalledEntryColumns[idxHrSWInstalledIndex] = 
      moFactory.createColumn(colHrSWInstalledIndex, 
                             SMIConstants.SYNTAX_INTEGER32,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrSWInstalledEntryColumns[idxHrSWInstalledName] = 
      moFactory.createColumn(colHrSWInstalledName, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefInternationalDisplayString);
    hrSWInstalledEntryColumns[idxHrSWInstalledID] = 
      moFactory.createColumn(colHrSWInstalledID, 
                             SMIConstants.SYNTAX_OBJECT_IDENTIFIER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleHostResourcesMib,
                             tcDefProductID);
    hrSWInstalledEntryColumns[idxHrSWInstalledType] = 
      moFactory.createColumn(colHrSWInstalledType, 
                             SMIConstants.SYNTAX_INTEGER,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY));
    hrSWInstalledEntryColumns[idxHrSWInstalledDate] = 
      moFactory.createColumn(colHrSWInstalledDate, 
                             SMIConstants.SYNTAX_OCTET_STRING,
                             moFactory.createAccess(MOAccessImpl.ACCESSIBLE_FOR_READ_ONLY),
                             tcModuleSNMPv2Tc,
                             tcDefDateAndTime);
    // Table model
    hrSWInstalledEntryModel = 
      moFactory.createTableModel(oidHrSWInstalledEntry,
                                 hrSWInstalledEntryIndex,
                                 hrSWInstalledEntryColumns);
    ((MOMutableTableModel)hrSWInstalledEntryModel).setRowFactory(
      new HrSWInstalledEntryRowFactory());
    hrSWInstalledEntry = 
      moFactory.createTable(oidHrSWInstalledEntry,
                            hrSWInstalledEntryIndex,
                            hrSWInstalledEntryColumns,
                            hrSWInstalledEntryModel);
  }



  public void registerMOs(MOServer server, OctetString context) 
    throws DuplicateRegistrationException 
  {
    // Scalar Objects
    server.register(this.hrSystemUptime, context);
    server.register(this.hrSystemDate, context);
    server.register(this.hrSystemInitialLoadDevice, context);
    server.register(this.hrSystemInitialLoadParameters, context);
    server.register(this.hrSystemNumUsers, context);
    server.register(this.hrSystemProcesses, context);
    server.register(this.hrSystemMaxProcesses, context);
    server.register(this.hrMemorySize, context);
    server.register(this.hrSWOSIndex, context);
    server.register(this.hrSWInstalledLastChange, context);
    server.register(this.hrSWInstalledLastUpdateTime, context);
    server.register(this.hrStorageEntry, context);
    server.register(this.hrDeviceEntry, context);
    server.register(this.hrProcessorEntry, context);
    server.register(this.hrNetworkEntry, context);
    server.register(this.hrPrinterEntry, context);
    server.register(this.hrDiskStorageEntry, context);
    server.register(this.hrPartitionEntry, context);
    server.register(this.hrFSEntry, context);
    server.register(this.hrSWRunEntry, context);
    server.register(this.hrSWRunPerfEntry, context);
    server.register(this.hrSWInstalledEntry, context);
//--AgentGen BEGIN=_registerMOs
//--AgentGen END
  }

  public void unregisterMOs(MOServer server, OctetString context) {
    // Scalar Objects
    server.unregister(this.hrSystemUptime, context);
    server.unregister(this.hrSystemDate, context);
    server.unregister(this.hrSystemInitialLoadDevice, context);
    server.unregister(this.hrSystemInitialLoadParameters, context);
    server.unregister(this.hrSystemNumUsers, context);
    server.unregister(this.hrSystemProcesses, context);
    server.unregister(this.hrSystemMaxProcesses, context);
    server.unregister(this.hrMemorySize, context);
    server.unregister(this.hrSWOSIndex, context);
    server.unregister(this.hrSWInstalledLastChange, context);
    server.unregister(this.hrSWInstalledLastUpdateTime, context);
    server.unregister(this.hrStorageEntry, context);
    server.unregister(this.hrDeviceEntry, context);
    server.unregister(this.hrProcessorEntry, context);
    server.unregister(this.hrNetworkEntry, context);
    server.unregister(this.hrPrinterEntry, context);
    server.unregister(this.hrDiskStorageEntry, context);
    server.unregister(this.hrPartitionEntry, context);
    server.unregister(this.hrFSEntry, context);
    server.unregister(this.hrSWRunEntry, context);
    server.unregister(this.hrSWRunPerfEntry, context);
    server.unregister(this.hrSWInstalledEntry, context);
//--AgentGen BEGIN=_unregisterMOs
//--AgentGen END
  }

  // Notifications

  // Scalars
  public class HrSystemDate extends DateAndTimeScalar {
    HrSystemDate(OID oid, MOAccess access) {
      super(oid, access, new OctetString());
//--AgentGen BEGIN=hrSystemDate
//--AgentGen END
    }

    public int isValueOK(SubRequest request) {
      Variable newValue =
        request.getVariableBinding().getVariable();
      int valueOK = super.isValueOK(request);
      if (valueOK != SnmpConstants.SNMP_ERROR_SUCCESS) {
      	return valueOK;
      }
      OctetString os = (OctetString)newValue;
      if (!(((os.length() >= 8) && (os.length() <= 8)) ||
        ((os.length() >= 11) && (os.length() <= 11)))) {
        valueOK = SnmpConstants.SNMP_ERROR_WRONG_LENGTH;
      }
     //--AgentGen BEGIN=hrSystemDate::isValueOK
     //--AgentGen END
      return valueOK; 
    }

    public OctetString getValue() {
     //--AgentGen BEGIN=hrSystemDate::getValue
     //--AgentGen END
      return (OctetString) super.getValue();
    }

    public int setValue(OctetString newValue) {
     //--AgentGen BEGIN=hrSystemDate::setValue
     //--AgentGen END
      return super.setValue(newValue);    
    }

     //--AgentGen BEGIN=hrSystemDate::_METHODS
     //--AgentGen END

  }

  public class HrSystemInitialLoadDevice extends MOScalar {
    HrSystemInitialLoadDevice(OID oid, MOAccess access) {
      super(oid, access, new Integer32());
//--AgentGen BEGIN=hrSystemInitialLoadDevice
//--AgentGen END
    }

    public int isValueOK(SubRequest request) {
      Variable newValue =
        request.getVariableBinding().getVariable();
      int valueOK = super.isValueOK(request);
      if (valueOK != SnmpConstants.SNMP_ERROR_SUCCESS) {
      	return valueOK;
      }
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= 1L) && (v <= 2147483647L)))) {
        valueOK = SnmpConstants.SNMP_ERROR_WRONG_VALUE;
      }    
     //--AgentGen BEGIN=hrSystemInitialLoadDevice::isValueOK
     //--AgentGen END
      return valueOK; 
    }

    public Integer32 getValue() {
     //--AgentGen BEGIN=hrSystemInitialLoadDevice::getValue
     //--AgentGen END
      return (Integer32) super.getValue();
    }

    public int setValue(Integer32 newValue) {
     //--AgentGen BEGIN=hrSystemInitialLoadDevice::setValue
     //--AgentGen END
      return super.setValue(newValue);    
    }

     //--AgentGen BEGIN=hrSystemInitialLoadDevice::_METHODS
     //--AgentGen END

  }

  public class HrSystemInitialLoadParameters extends MOScalar {
    HrSystemInitialLoadParameters(OID oid, MOAccess access) {
      super(oid, access, new OctetString());
//--AgentGen BEGIN=hrSystemInitialLoadParameters
//--AgentGen END
    }

    public int isValueOK(SubRequest request) {
      Variable newValue =
        request.getVariableBinding().getVariable();
      int valueOK = super.isValueOK(request);
      if (valueOK != SnmpConstants.SNMP_ERROR_SUCCESS) {
      	return valueOK;
      }
      OctetString os = (OctetString)newValue;
      if (!(((os.length() >= 0) && (os.length() <= 128)))) {
        valueOK = SnmpConstants.SNMP_ERROR_WRONG_LENGTH;
      }
     //--AgentGen BEGIN=hrSystemInitialLoadParameters::isValueOK
     //--AgentGen END
      return valueOK; 
    }

    public OctetString getValue() {
     //--AgentGen BEGIN=hrSystemInitialLoadParameters::getValue
     //--AgentGen END
      return (OctetString) super.getValue();
    }

    public int setValue(OctetString newValue) {
     //--AgentGen BEGIN=hrSystemInitialLoadParameters::setValue
     //--AgentGen END
      return super.setValue(newValue);    
    }

     //--AgentGen BEGIN=hrSystemInitialLoadParameters::_METHODS
     //--AgentGen END

  }


  // Value Validators
  /**
   * The <code>HrSystemDateValidator</code> implements the value
   * validation for <code>HrSystemDate</code>.
   */
  static class HrSystemDateValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      OctetString os = (OctetString)newValue;
      if (!(((os.length() >= 8) && (os.length() <= 8)) ||
        ((os.length() >= 11) && (os.length() <= 11)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
        return;
      }
     //--AgentGen BEGIN=hrSystemDate::validate
     //--AgentGen END
    }
  }
  /**
   * The <code>HrSystemInitialLoadDeviceValidator</code> implements the value
   * validation for <code>HrSystemInitialLoadDevice</code>.
   */
  static class HrSystemInitialLoadDeviceValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= 1L) && (v <= 2147483647L)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_VALUE);
        return;
      }
     //--AgentGen BEGIN=hrSystemInitialLoadDevice::validate
     //--AgentGen END
    }
  }
  /**
   * The <code>HrSystemInitialLoadParametersValidator</code> implements the value
   * validation for <code>HrSystemInitialLoadParameters</code>.
   */
  static class HrSystemInitialLoadParametersValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      OctetString os = (OctetString)newValue;
      if (!(((os.length() >= 0) && (os.length() <= 128)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
        return;
      }
     //--AgentGen BEGIN=hrSystemInitialLoadParameters::validate
     //--AgentGen END
    }
  }

  /**
   * The <code>HrStorageSizeValidator</code> implements the value
   * validation for <code>HrStorageSize</code>.
   */
  static class HrStorageSizeValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      long v = ((Integer32)newValue).getValue();
      if (!(((v >= 0L) && (v <= 2147483647L)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_VALUE);
        return;
      }
     //--AgentGen BEGIN=hrStorageSize::validate
     //--AgentGen END
    }
  }
  /**
   * The <code>HrFSLastFullBackupDateValidator</code> implements the value
   * validation for <code>HrFSLastFullBackupDate</code>.
   */
  static class HrFSLastFullBackupDateValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      OctetString os = (OctetString)newValue;
      if (!(((os.length() >= 8) && (os.length() <= 8)) ||
        ((os.length() >= 11) && (os.length() <= 11)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
        return;
      }
     //--AgentGen BEGIN=hrFSLastFullBackupDate::validate
     //--AgentGen END
    }
  }
  /**
   * The <code>HrFSLastPartialBackupDateValidator</code> implements the value
   * validation for <code>HrFSLastPartialBackupDate</code>.
   */
  static class HrFSLastPartialBackupDateValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
      OctetString os = (OctetString)newValue;
      if (!(((os.length() >= 8) && (os.length() <= 8)) ||
        ((os.length() >= 11) && (os.length() <= 11)))) {
        validationEvent.setValidationStatus(SnmpConstants.SNMP_ERROR_WRONG_LENGTH);
        return;
      }
     //--AgentGen BEGIN=hrFSLastPartialBackupDate::validate
     //--AgentGen END
    }
  }
  /**
   * The <code>HrSWRunStatusValidator</code> implements the value
   * validation for <code>HrSWRunStatus</code>.
   */
  static class HrSWRunStatusValidator implements MOValueValidationListener {
    
    public void validate(MOValueValidationEvent validationEvent) {
      Variable newValue = validationEvent.getNewValue();
     //--AgentGen BEGIN=hrSWRunStatus::validate
     //--AgentGen END
    }
  }

  // Rows and Factories

  public class HrStorageEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrStorageEntry::RowMembers
     //--AgentGen END

    public HrStorageEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrStorageEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrStorageIndex() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrStorageIndex);
    }  
    
    public void setHrStorageIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageIndex
     //--AgentGen END
      super.setValue(idxHrStorageIndex, newValue);
    }
    
    public OID getHrStorageType() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageType
     //--AgentGen END
      return (OID) super.getValue(idxHrStorageType);
    }  
    
    public void setHrStorageType(OID newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageType
     //--AgentGen END
      super.setValue(idxHrStorageType, newValue);
    }
    
    public OctetString getHrStorageDescr() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageDescr
     //--AgentGen END
      return (OctetString) super.getValue(idxHrStorageDescr);
    }  
    
    public void setHrStorageDescr(OctetString newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageDescr
     //--AgentGen END
      super.setValue(idxHrStorageDescr, newValue);
    }
    
    public Integer32 getHrStorageAllocationUnits() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageAllocationUnits
     //--AgentGen END
      return (Integer32) super.getValue(idxHrStorageAllocationUnits);
    }  
    
    public void setHrStorageAllocationUnits(Integer32 newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageAllocationUnits
     //--AgentGen END
      super.setValue(idxHrStorageAllocationUnits, newValue);
    }
    
    public Integer32 getHrStorageSize() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageSize
     //--AgentGen END
      return (Integer32) super.getValue(idxHrStorageSize);
    }  
    
    public void setHrStorageSize(Integer32 newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageSize
     //--AgentGen END
      super.setValue(idxHrStorageSize, newValue);
    }
    
    public Integer32 getHrStorageUsed() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageUsed
     //--AgentGen END
      return (Integer32) super.getValue(idxHrStorageUsed);
    }  
    
    public void setHrStorageUsed(Integer32 newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageUsed
     //--AgentGen END
      super.setValue(idxHrStorageUsed, newValue);
    }
    
    public Counter32 getHrStorageAllocationFailures() {
     //--AgentGen BEGIN=hrStorageEntry::getHrStorageAllocationFailures
     //--AgentGen END
      return (Counter32) super.getValue(idxHrStorageAllocationFailures);
    }  
    
    public void setHrStorageAllocationFailures(Counter32 newValue) {
     //--AgentGen BEGIN=hrStorageEntry::setHrStorageAllocationFailures
     //--AgentGen END
      super.setValue(idxHrStorageAllocationFailures, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrStorageEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrStorageIndex: 
        	return getHrStorageIndex();
        case idxHrStorageType: 
        	return getHrStorageType();
        case idxHrStorageDescr: 
        	return getHrStorageDescr();
        case idxHrStorageAllocationUnits: 
        	return getHrStorageAllocationUnits();
        case idxHrStorageSize: 
        	return getHrStorageSize();
        case idxHrStorageUsed: 
        	return getHrStorageUsed();
        case idxHrStorageAllocationFailures: 
        	return getHrStorageAllocationFailures();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrStorageEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrStorageIndex: 
        	setHrStorageIndex((Integer32)value);
        	break;
        case idxHrStorageType: 
        	setHrStorageType((OID)value);
        	break;
        case idxHrStorageDescr: 
        	setHrStorageDescr((OctetString)value);
        	break;
        case idxHrStorageAllocationUnits: 
        	setHrStorageAllocationUnits((Integer32)value);
        	break;
        case idxHrStorageSize: 
        	setHrStorageSize((Integer32)value);
        	break;
        case idxHrStorageUsed: 
        	setHrStorageUsed((Integer32)value);
        	break;
        case idxHrStorageAllocationFailures: 
        	setHrStorageAllocationFailures((Counter32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrStorageEntry::Row
     //--AgentGen END
  }
  
  class HrStorageEntryRowFactory implements MOTableRowFactory
  {
    public synchronized HrStorageEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrStorageEntryRow row = 
        new HrStorageEntryRow(index, values);
     //--AgentGen BEGIN=hrStorageEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrStorageEntryRow row) {
     //--AgentGen BEGIN=hrStorageEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrStorageEntry::RowFactory
     //--AgentGen END
  }

  public class HrDeviceEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrDeviceEntry::RowMembers
     //--AgentGen END

    public HrDeviceEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrDeviceEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrDeviceIndex() {
     //--AgentGen BEGIN=hrDeviceEntry::getHrDeviceIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrDeviceIndex);
    }  
    
    public void setHrDeviceIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrDeviceEntry::setHrDeviceIndex
     //--AgentGen END
      super.setValue(idxHrDeviceIndex, newValue);
    }
    
    public OID getHrDeviceType() {
     //--AgentGen BEGIN=hrDeviceEntry::getHrDeviceType
     //--AgentGen END
      return (OID) super.getValue(idxHrDeviceType);
    }  
    
    public void setHrDeviceType(OID newValue) {
     //--AgentGen BEGIN=hrDeviceEntry::setHrDeviceType
     //--AgentGen END
      super.setValue(idxHrDeviceType, newValue);
    }
    
    public OctetString getHrDeviceDescr() {
     //--AgentGen BEGIN=hrDeviceEntry::getHrDeviceDescr
     //--AgentGen END
      return (OctetString) super.getValue(idxHrDeviceDescr);
    }  
    
    public void setHrDeviceDescr(OctetString newValue) {
     //--AgentGen BEGIN=hrDeviceEntry::setHrDeviceDescr
     //--AgentGen END
      super.setValue(idxHrDeviceDescr, newValue);
    }
    
    public OID getHrDeviceID() {
     //--AgentGen BEGIN=hrDeviceEntry::getHrDeviceID
     //--AgentGen END
      return (OID) super.getValue(idxHrDeviceID);
    }  
    
    public void setHrDeviceID(OID newValue) {
     //--AgentGen BEGIN=hrDeviceEntry::setHrDeviceID
     //--AgentGen END
      super.setValue(idxHrDeviceID, newValue);
    }
    
    public Integer32 getHrDeviceStatus() {
     //--AgentGen BEGIN=hrDeviceEntry::getHrDeviceStatus
     //--AgentGen END
      return (Integer32) super.getValue(idxHrDeviceStatus);
    }  
    
    public void setHrDeviceStatus(Integer32 newValue) {
     //--AgentGen BEGIN=hrDeviceEntry::setHrDeviceStatus
     //--AgentGen END
      super.setValue(idxHrDeviceStatus, newValue);
    }
    
    public Counter32 getHrDeviceErrors() {
     //--AgentGen BEGIN=hrDeviceEntry::getHrDeviceErrors
     //--AgentGen END
      return (Counter32) super.getValue(idxHrDeviceErrors);
    }  
    
    public void setHrDeviceErrors(Counter32 newValue) {
     //--AgentGen BEGIN=hrDeviceEntry::setHrDeviceErrors
     //--AgentGen END
      super.setValue(idxHrDeviceErrors, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrDeviceEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrDeviceIndex: 
        	return getHrDeviceIndex();
        case idxHrDeviceType: 
        	return getHrDeviceType();
        case idxHrDeviceDescr: 
        	return getHrDeviceDescr();
        case idxHrDeviceID: 
        	return getHrDeviceID();
        case idxHrDeviceStatus: 
        	return getHrDeviceStatus();
        case idxHrDeviceErrors: 
        	return getHrDeviceErrors();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrDeviceEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrDeviceIndex: 
        	setHrDeviceIndex((Integer32)value);
        	break;
        case idxHrDeviceType: 
        	setHrDeviceType((OID)value);
        	break;
        case idxHrDeviceDescr: 
        	setHrDeviceDescr((OctetString)value);
        	break;
        case idxHrDeviceID: 
        	setHrDeviceID((OID)value);
        	break;
        case idxHrDeviceStatus: 
        	setHrDeviceStatus((Integer32)value);
        	break;
        case idxHrDeviceErrors: 
        	setHrDeviceErrors((Counter32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrDeviceEntry::Row
     //--AgentGen END
  }
  
  class HrDeviceEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrDeviceEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrDeviceEntryRow row = 
        new HrDeviceEntryRow(index, values);
     //--AgentGen BEGIN=hrDeviceEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrDeviceEntryRow row) {
     //--AgentGen BEGIN=hrDeviceEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrDeviceEntry::RowFactory
     //--AgentGen END
  }

  public class HrProcessorEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrProcessorEntry::RowMembers
     //--AgentGen END

    public HrProcessorEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrProcessorEntry::RowConstructor
     //--AgentGen END
    }
    
    public OID getHrProcessorFrwID() {
     //--AgentGen BEGIN=hrProcessorEntry::getHrProcessorFrwID
     //--AgentGen END
      return (OID) super.getValue(idxHrProcessorFrwID);
    }  
    
    public void setHrProcessorFrwID(OID newValue) {
     //--AgentGen BEGIN=hrProcessorEntry::setHrProcessorFrwID
     //--AgentGen END
      super.setValue(idxHrProcessorFrwID, newValue);
    }
    
    public Integer32 getHrProcessorLoad() {
     //--AgentGen BEGIN=hrProcessorEntry::getHrProcessorLoad
     //--AgentGen END
      return (Integer32) super.getValue(idxHrProcessorLoad);
    }  
    
    public void setHrProcessorLoad(Integer32 newValue) {
     //--AgentGen BEGIN=hrProcessorEntry::setHrProcessorLoad
     //--AgentGen END
      super.setValue(idxHrProcessorLoad, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrProcessorEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrProcessorFrwID: 
        	return getHrProcessorFrwID();
        case idxHrProcessorLoad: 
        	return getHrProcessorLoad();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrProcessorEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrProcessorFrwID: 
        	setHrProcessorFrwID((OID)value);
        	break;
        case idxHrProcessorLoad: 
        	setHrProcessorLoad((Integer32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrProcessorEntry::Row
     //--AgentGen END
  }
  
  class HrProcessorEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrProcessorEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrProcessorEntryRow row = 
        new HrProcessorEntryRow(index, values);
     //--AgentGen BEGIN=hrProcessorEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrProcessorEntryRow row) {
     //--AgentGen BEGIN=hrProcessorEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrProcessorEntry::RowFactory
     //--AgentGen END
  }

  public class HrNetworkEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrNetworkEntry::RowMembers
     //--AgentGen END

    public HrNetworkEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrNetworkEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrNetworkIfIndex() {
     //--AgentGen BEGIN=hrNetworkEntry::getHrNetworkIfIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrNetworkIfIndex);
    }  
    
    public void setHrNetworkIfIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrNetworkEntry::setHrNetworkIfIndex
     //--AgentGen END
      super.setValue(idxHrNetworkIfIndex, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrNetworkEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrNetworkIfIndex: 
        	return getHrNetworkIfIndex();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrNetworkEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrNetworkIfIndex: 
        	setHrNetworkIfIndex((Integer32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrNetworkEntry::Row
     //--AgentGen END
  }
  
  class HrNetworkEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrNetworkEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrNetworkEntryRow row = 
        new HrNetworkEntryRow(index, values);
     //--AgentGen BEGIN=hrNetworkEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrNetworkEntryRow row) {
     //--AgentGen BEGIN=hrNetworkEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrNetworkEntry::RowFactory
     //--AgentGen END
  }

  public class HrPrinterEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrPrinterEntry::RowMembers
     //--AgentGen END

    public HrPrinterEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrPrinterEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrPrinterStatus() {
     //--AgentGen BEGIN=hrPrinterEntry::getHrPrinterStatus
     //--AgentGen END
      return (Integer32) super.getValue(idxHrPrinterStatus);
    }  
    
    public void setHrPrinterStatus(Integer32 newValue) {
     //--AgentGen BEGIN=hrPrinterEntry::setHrPrinterStatus
     //--AgentGen END
      super.setValue(idxHrPrinterStatus, newValue);
    }
    
    public OctetString getHrPrinterDetectedErrorState() {
     //--AgentGen BEGIN=hrPrinterEntry::getHrPrinterDetectedErrorState
     //--AgentGen END
      return (OctetString) super.getValue(idxHrPrinterDetectedErrorState);
    }  
    
    public void setHrPrinterDetectedErrorState(OctetString newValue) {
     //--AgentGen BEGIN=hrPrinterEntry::setHrPrinterDetectedErrorState
     //--AgentGen END
      super.setValue(idxHrPrinterDetectedErrorState, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrPrinterEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrPrinterStatus: 
        	return getHrPrinterStatus();
        case idxHrPrinterDetectedErrorState: 
        	return getHrPrinterDetectedErrorState();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrPrinterEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrPrinterStatus: 
        	setHrPrinterStatus((Integer32)value);
        	break;
        case idxHrPrinterDetectedErrorState: 
        	setHrPrinterDetectedErrorState((OctetString)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrPrinterEntry::Row
     //--AgentGen END
  }
  
  class HrPrinterEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrPrinterEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrPrinterEntryRow row = 
        new HrPrinterEntryRow(index, values);
     //--AgentGen BEGIN=hrPrinterEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrPrinterEntryRow row) {
     //--AgentGen BEGIN=hrPrinterEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrPrinterEntry::RowFactory
     //--AgentGen END
  }

  public class HrDiskStorageEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrDiskStorageEntry::RowMembers
     //--AgentGen END

    public HrDiskStorageEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrDiskStorageEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrDiskStorageAccess() {
     //--AgentGen BEGIN=hrDiskStorageEntry::getHrDiskStorageAccess
     //--AgentGen END
      return (Integer32) super.getValue(idxHrDiskStorageAccess);
    }  
    
    public void setHrDiskStorageAccess(Integer32 newValue) {
     //--AgentGen BEGIN=hrDiskStorageEntry::setHrDiskStorageAccess
     //--AgentGen END
      super.setValue(idxHrDiskStorageAccess, newValue);
    }
    
    public Integer32 getHrDiskStorageMedia() {
     //--AgentGen BEGIN=hrDiskStorageEntry::getHrDiskStorageMedia
     //--AgentGen END
      return (Integer32) super.getValue(idxHrDiskStorageMedia);
    }  
    
    public void setHrDiskStorageMedia(Integer32 newValue) {
     //--AgentGen BEGIN=hrDiskStorageEntry::setHrDiskStorageMedia
     //--AgentGen END
      super.setValue(idxHrDiskStorageMedia, newValue);
    }
    
    public Integer32 getHrDiskStorageRemoveble() {
     //--AgentGen BEGIN=hrDiskStorageEntry::getHrDiskStorageRemoveble
     //--AgentGen END
      return (Integer32) super.getValue(idxHrDiskStorageRemoveble);
    }  
    
    public void setHrDiskStorageRemoveble(Integer32 newValue) {
     //--AgentGen BEGIN=hrDiskStorageEntry::setHrDiskStorageRemoveble
     //--AgentGen END
      super.setValue(idxHrDiskStorageRemoveble, newValue);
    }
    
    public Integer32 getHrDiskStorageCapacity() {
     //--AgentGen BEGIN=hrDiskStorageEntry::getHrDiskStorageCapacity
     //--AgentGen END
      return (Integer32) super.getValue(idxHrDiskStorageCapacity);
    }  
    
    public void setHrDiskStorageCapacity(Integer32 newValue) {
     //--AgentGen BEGIN=hrDiskStorageEntry::setHrDiskStorageCapacity
     //--AgentGen END
      super.setValue(idxHrDiskStorageCapacity, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrDiskStorageEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrDiskStorageAccess: 
        	return getHrDiskStorageAccess();
        case idxHrDiskStorageMedia: 
        	return getHrDiskStorageMedia();
        case idxHrDiskStorageRemoveble: 
        	return getHrDiskStorageRemoveble();
        case idxHrDiskStorageCapacity: 
        	return getHrDiskStorageCapacity();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrDiskStorageEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrDiskStorageAccess: 
        	setHrDiskStorageAccess((Integer32)value);
        	break;
        case idxHrDiskStorageMedia: 
        	setHrDiskStorageMedia((Integer32)value);
        	break;
        case idxHrDiskStorageRemoveble: 
        	setHrDiskStorageRemoveble((Integer32)value);
        	break;
        case idxHrDiskStorageCapacity: 
        	setHrDiskStorageCapacity((Integer32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrDiskStorageEntry::Row
     //--AgentGen END
  }
  
  class HrDiskStorageEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrDiskStorageEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrDiskStorageEntryRow row = 
        new HrDiskStorageEntryRow(index, values);
     //--AgentGen BEGIN=hrDiskStorageEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrDiskStorageEntryRow row) {
     //--AgentGen BEGIN=hrDiskStorageEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrDiskStorageEntry::RowFactory
     //--AgentGen END
  }

  public class HrPartitionEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrPartitionEntry::RowMembers
     //--AgentGen END

    public HrPartitionEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrPartitionEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrPartitionIndex() {
     //--AgentGen BEGIN=hrPartitionEntry::getHrPartitionIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrPartitionIndex);
    }  
    
    public void setHrPartitionIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrPartitionEntry::setHrPartitionIndex
     //--AgentGen END
      super.setValue(idxHrPartitionIndex, newValue);
    }
    
    public OctetString getHrPartitionLabel() {
     //--AgentGen BEGIN=hrPartitionEntry::getHrPartitionLabel
     //--AgentGen END
      return (OctetString) super.getValue(idxHrPartitionLabel);
    }  
    
    public void setHrPartitionLabel(OctetString newValue) {
     //--AgentGen BEGIN=hrPartitionEntry::setHrPartitionLabel
     //--AgentGen END
      super.setValue(idxHrPartitionLabel, newValue);
    }
    
    public OctetString getHrPartitionID() {
     //--AgentGen BEGIN=hrPartitionEntry::getHrPartitionID
     //--AgentGen END
      return (OctetString) super.getValue(idxHrPartitionID);
    }  
    
    public void setHrPartitionID(OctetString newValue) {
     //--AgentGen BEGIN=hrPartitionEntry::setHrPartitionID
     //--AgentGen END
      super.setValue(idxHrPartitionID, newValue);
    }
    
    public Integer32 getHrPartitionSize() {
     //--AgentGen BEGIN=hrPartitionEntry::getHrPartitionSize
     //--AgentGen END
      return (Integer32) super.getValue(idxHrPartitionSize);
    }  
    
    public void setHrPartitionSize(Integer32 newValue) {
     //--AgentGen BEGIN=hrPartitionEntry::setHrPartitionSize
     //--AgentGen END
      super.setValue(idxHrPartitionSize, newValue);
    }
    
    public Integer32 getHrPartitionFSIndex() {
     //--AgentGen BEGIN=hrPartitionEntry::getHrPartitionFSIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrPartitionFSIndex);
    }  
    
    public void setHrPartitionFSIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrPartitionEntry::setHrPartitionFSIndex
     //--AgentGen END
      super.setValue(idxHrPartitionFSIndex, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrPartitionEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrPartitionIndex: 
        	return getHrPartitionIndex();
        case idxHrPartitionLabel: 
        	return getHrPartitionLabel();
        case idxHrPartitionID: 
        	return getHrPartitionID();
        case idxHrPartitionSize: 
        	return getHrPartitionSize();
        case idxHrPartitionFSIndex: 
        	return getHrPartitionFSIndex();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrPartitionEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrPartitionIndex: 
        	setHrPartitionIndex((Integer32)value);
        	break;
        case idxHrPartitionLabel: 
        	setHrPartitionLabel((OctetString)value);
        	break;
        case idxHrPartitionID: 
        	setHrPartitionID((OctetString)value);
        	break;
        case idxHrPartitionSize: 
        	setHrPartitionSize((Integer32)value);
        	break;
        case idxHrPartitionFSIndex: 
        	setHrPartitionFSIndex((Integer32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrPartitionEntry::Row
     //--AgentGen END
  }
  
  class HrPartitionEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrPartitionEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrPartitionEntryRow row = 
        new HrPartitionEntryRow(index, values);
     //--AgentGen BEGIN=hrPartitionEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrPartitionEntryRow row) {
     //--AgentGen BEGIN=hrPartitionEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrPartitionEntry::RowFactory
     //--AgentGen END
  }

  public class HrFSEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrFSEntry::RowMembers
     //--AgentGen END

    public HrFSEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrFSEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrFSIndex() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrFSIndex);
    }  
    
    public void setHrFSIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSIndex
     //--AgentGen END
      super.setValue(idxHrFSIndex, newValue);
    }
    
    public OctetString getHrFSMountPoint() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSMountPoint
     //--AgentGen END
      return (OctetString) super.getValue(idxHrFSMountPoint);
    }  
    
    public void setHrFSMountPoint(OctetString newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSMountPoint
     //--AgentGen END
      super.setValue(idxHrFSMountPoint, newValue);
    }
    
    public OctetString getHrFSRemoteMountPoint() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSRemoteMountPoint
     //--AgentGen END
      return (OctetString) super.getValue(idxHrFSRemoteMountPoint);
    }  
    
    public void setHrFSRemoteMountPoint(OctetString newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSRemoteMountPoint
     //--AgentGen END
      super.setValue(idxHrFSRemoteMountPoint, newValue);
    }
    
    public OID getHrFSType() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSType
     //--AgentGen END
      return (OID) super.getValue(idxHrFSType);
    }  
    
    public void setHrFSType(OID newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSType
     //--AgentGen END
      super.setValue(idxHrFSType, newValue);
    }
    
    public Integer32 getHrFSAccess() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSAccess
     //--AgentGen END
      return (Integer32) super.getValue(idxHrFSAccess);
    }  
    
    public void setHrFSAccess(Integer32 newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSAccess
     //--AgentGen END
      super.setValue(idxHrFSAccess, newValue);
    }
    
    public Integer32 getHrFSBootable() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSBootable
     //--AgentGen END
      return (Integer32) super.getValue(idxHrFSBootable);
    }  
    
    public void setHrFSBootable(Integer32 newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSBootable
     //--AgentGen END
      super.setValue(idxHrFSBootable, newValue);
    }
    
    public Integer32 getHrFSStorageIndex() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSStorageIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrFSStorageIndex);
    }  
    
    public void setHrFSStorageIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSStorageIndex
     //--AgentGen END
      super.setValue(idxHrFSStorageIndex, newValue);
    }
    
    public OctetString getHrFSLastFullBackupDate() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSLastFullBackupDate
     //--AgentGen END
      return (OctetString) super.getValue(idxHrFSLastFullBackupDate);
    }  
    
    public void setHrFSLastFullBackupDate(OctetString newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSLastFullBackupDate
     //--AgentGen END
      super.setValue(idxHrFSLastFullBackupDate, newValue);
    }
    
    public OctetString getHrFSLastPartialBackupDate() {
     //--AgentGen BEGIN=hrFSEntry::getHrFSLastPartialBackupDate
     //--AgentGen END
      return (OctetString) super.getValue(idxHrFSLastPartialBackupDate);
    }  
    
    public void setHrFSLastPartialBackupDate(OctetString newValue) {
     //--AgentGen BEGIN=hrFSEntry::setHrFSLastPartialBackupDate
     //--AgentGen END
      super.setValue(idxHrFSLastPartialBackupDate, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrFSEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrFSIndex: 
        	return getHrFSIndex();
        case idxHrFSMountPoint: 
        	return getHrFSMountPoint();
        case idxHrFSRemoteMountPoint: 
        	return getHrFSRemoteMountPoint();
        case idxHrFSType: 
        	return getHrFSType();
        case idxHrFSAccess: 
        	return getHrFSAccess();
        case idxHrFSBootable: 
        	return getHrFSBootable();
        case idxHrFSStorageIndex: 
        	return getHrFSStorageIndex();
        case idxHrFSLastFullBackupDate: 
        	return getHrFSLastFullBackupDate();
        case idxHrFSLastPartialBackupDate: 
        	return getHrFSLastPartialBackupDate();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrFSEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrFSIndex: 
        	setHrFSIndex((Integer32)value);
        	break;
        case idxHrFSMountPoint: 
        	setHrFSMountPoint((OctetString)value);
        	break;
        case idxHrFSRemoteMountPoint: 
        	setHrFSRemoteMountPoint((OctetString)value);
        	break;
        case idxHrFSType: 
        	setHrFSType((OID)value);
        	break;
        case idxHrFSAccess: 
        	setHrFSAccess((Integer32)value);
        	break;
        case idxHrFSBootable: 
        	setHrFSBootable((Integer32)value);
        	break;
        case idxHrFSStorageIndex: 
        	setHrFSStorageIndex((Integer32)value);
        	break;
        case idxHrFSLastFullBackupDate: 
        	setHrFSLastFullBackupDate((OctetString)value);
        	break;
        case idxHrFSLastPartialBackupDate: 
        	setHrFSLastPartialBackupDate((OctetString)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrFSEntry::Row
     //--AgentGen END
  }
  
  class HrFSEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrFSEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrFSEntryRow row = 
        new HrFSEntryRow(index, values);
     //--AgentGen BEGIN=hrFSEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrFSEntryRow row) {
     //--AgentGen BEGIN=hrFSEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrFSEntry::RowFactory
     //--AgentGen END
  }

  public class HrSWRunEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrSWRunEntry::RowMembers
     //--AgentGen END

    public HrSWRunEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrSWRunEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrSWRunIndex() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWRunIndex);
    }  
    
    public void setHrSWRunIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunIndex
     //--AgentGen END
      super.setValue(idxHrSWRunIndex, newValue);
    }
    
    public OctetString getHrSWRunName() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunName
     //--AgentGen END
      return (OctetString) super.getValue(idxHrSWRunName);
    }  
    
    public void setHrSWRunName(OctetString newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunName
     //--AgentGen END
      super.setValue(idxHrSWRunName, newValue);
    }
    
    public OID getHrSWRunID() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunID
     //--AgentGen END
      return (OID) super.getValue(idxHrSWRunID);
    }  
    
    public void setHrSWRunID(OID newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunID
     //--AgentGen END
      super.setValue(idxHrSWRunID, newValue);
    }
    
    public OctetString getHrSWRunPath() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunPath
     //--AgentGen END
      return (OctetString) super.getValue(idxHrSWRunPath);
    }  
    
    public void setHrSWRunPath(OctetString newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunPath
     //--AgentGen END
      super.setValue(idxHrSWRunPath, newValue);
    }
    
    public OctetString getHrSWRunParameters() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunParameters
     //--AgentGen END
      return (OctetString) super.getValue(idxHrSWRunParameters);
    }  
    
    public void setHrSWRunParameters(OctetString newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunParameters
     //--AgentGen END
      super.setValue(idxHrSWRunParameters, newValue);
    }
    
    public Integer32 getHrSWRunType() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunType
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWRunType);
    }  
    
    public void setHrSWRunType(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunType
     //--AgentGen END
      super.setValue(idxHrSWRunType, newValue);
    }
    
    public Integer32 getHrSWRunStatus() {
     //--AgentGen BEGIN=hrSWRunEntry::getHrSWRunStatus
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWRunStatus);
    }  
    
    public void setHrSWRunStatus(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWRunEntry::setHrSWRunStatus
     //--AgentGen END
      super.setValue(idxHrSWRunStatus, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrSWRunEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrSWRunIndex: 
        	return getHrSWRunIndex();
        case idxHrSWRunName: 
        	return getHrSWRunName();
        case idxHrSWRunID: 
        	return getHrSWRunID();
        case idxHrSWRunPath: 
        	return getHrSWRunPath();
        case idxHrSWRunParameters: 
        	return getHrSWRunParameters();
        case idxHrSWRunType: 
        	return getHrSWRunType();
        case idxHrSWRunStatus: 
        	return getHrSWRunStatus();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrSWRunEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrSWRunIndex: 
        	setHrSWRunIndex((Integer32)value);
        	break;
        case idxHrSWRunName: 
        	setHrSWRunName((OctetString)value);
        	break;
        case idxHrSWRunID: 
        	setHrSWRunID((OID)value);
        	break;
        case idxHrSWRunPath: 
        	setHrSWRunPath((OctetString)value);
        	break;
        case idxHrSWRunParameters: 
        	setHrSWRunParameters((OctetString)value);
        	break;
        case idxHrSWRunType: 
        	setHrSWRunType((Integer32)value);
        	break;
        case idxHrSWRunStatus: 
        	setHrSWRunStatus((Integer32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrSWRunEntry::Row
     //--AgentGen END
  }
  
  class HrSWRunEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrSWRunEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrSWRunEntryRow row = 
        new HrSWRunEntryRow(index, values);
     //--AgentGen BEGIN=hrSWRunEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrSWRunEntryRow row) {
     //--AgentGen BEGIN=hrSWRunEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrSWRunEntry::RowFactory
     //--AgentGen END
  }

  public class HrSWRunPerfEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrSWRunPerfEntry::RowMembers
     //--AgentGen END

    public HrSWRunPerfEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrSWRunPerfEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrSWRunPerfCPU() {
     //--AgentGen BEGIN=hrSWRunPerfEntry::getHrSWRunPerfCPU
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWRunPerfCPU);
    }  
    
    public void setHrSWRunPerfCPU(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWRunPerfEntry::setHrSWRunPerfCPU
     //--AgentGen END
      super.setValue(idxHrSWRunPerfCPU, newValue);
    }
    
    public Integer32 getHrSWRunPerfMem() {
     //--AgentGen BEGIN=hrSWRunPerfEntry::getHrSWRunPerfMem
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWRunPerfMem);
    }  
    
    public void setHrSWRunPerfMem(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWRunPerfEntry::setHrSWRunPerfMem
     //--AgentGen END
      super.setValue(idxHrSWRunPerfMem, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrSWRunPerfEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrSWRunPerfCPU: 
        	return getHrSWRunPerfCPU();
        case idxHrSWRunPerfMem: 
        	return getHrSWRunPerfMem();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrSWRunPerfEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrSWRunPerfCPU: 
        	setHrSWRunPerfCPU((Integer32)value);
        	break;
        case idxHrSWRunPerfMem: 
        	setHrSWRunPerfMem((Integer32)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrSWRunPerfEntry::Row
     //--AgentGen END
  }
  
  class HrSWRunPerfEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrSWRunPerfEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrSWRunPerfEntryRow row = 
        new HrSWRunPerfEntryRow(index, values);
     //--AgentGen BEGIN=hrSWRunPerfEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrSWRunPerfEntryRow row) {
     //--AgentGen BEGIN=hrSWRunPerfEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrSWRunPerfEntry::RowFactory
     //--AgentGen END
  }

  public class HrSWInstalledEntryRow extends DefaultMOMutableRow2PC {

     //--AgentGen BEGIN=hrSWInstalledEntry::RowMembers
     //--AgentGen END

    public HrSWInstalledEntryRow(OID index, Variable[] values) {
      super(index, values);
     //--AgentGen BEGIN=hrSWInstalledEntry::RowConstructor
     //--AgentGen END
    }
    
    public Integer32 getHrSWInstalledIndex() {
     //--AgentGen BEGIN=hrSWInstalledEntry::getHrSWInstalledIndex
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWInstalledIndex);
    }  
    
    public void setHrSWInstalledIndex(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWInstalledEntry::setHrSWInstalledIndex
     //--AgentGen END
      super.setValue(idxHrSWInstalledIndex, newValue);
    }
    
    public OctetString getHrSWInstalledName() {
     //--AgentGen BEGIN=hrSWInstalledEntry::getHrSWInstalledName
     //--AgentGen END
      return (OctetString) super.getValue(idxHrSWInstalledName);
    }  
    
    public void setHrSWInstalledName(OctetString newValue) {
     //--AgentGen BEGIN=hrSWInstalledEntry::setHrSWInstalledName
     //--AgentGen END
      super.setValue(idxHrSWInstalledName, newValue);
    }
    
    public OID getHrSWInstalledID() {
     //--AgentGen BEGIN=hrSWInstalledEntry::getHrSWInstalledID
     //--AgentGen END
      return (OID) super.getValue(idxHrSWInstalledID);
    }  
    
    public void setHrSWInstalledID(OID newValue) {
     //--AgentGen BEGIN=hrSWInstalledEntry::setHrSWInstalledID
     //--AgentGen END
      super.setValue(idxHrSWInstalledID, newValue);
    }
    
    public Integer32 getHrSWInstalledType() {
     //--AgentGen BEGIN=hrSWInstalledEntry::getHrSWInstalledType
     //--AgentGen END
      return (Integer32) super.getValue(idxHrSWInstalledType);
    }  
    
    public void setHrSWInstalledType(Integer32 newValue) {
     //--AgentGen BEGIN=hrSWInstalledEntry::setHrSWInstalledType
     //--AgentGen END
      super.setValue(idxHrSWInstalledType, newValue);
    }
    
    public OctetString getHrSWInstalledDate() {
     //--AgentGen BEGIN=hrSWInstalledEntry::getHrSWInstalledDate
     //--AgentGen END
      return (OctetString) super.getValue(idxHrSWInstalledDate);
    }  
    
    public void setHrSWInstalledDate(OctetString newValue) {
     //--AgentGen BEGIN=hrSWInstalledEntry::setHrSWInstalledDate
     //--AgentGen END
      super.setValue(idxHrSWInstalledDate, newValue);
    }
    
    public Variable getValue(int column) {
     //--AgentGen BEGIN=hrSWInstalledEntry::RowGetValue
     //--AgentGen END
      switch(column) {
        case idxHrSWInstalledIndex: 
        	return getHrSWInstalledIndex();
        case idxHrSWInstalledName: 
        	return getHrSWInstalledName();
        case idxHrSWInstalledID: 
        	return getHrSWInstalledID();
        case idxHrSWInstalledType: 
        	return getHrSWInstalledType();
        case idxHrSWInstalledDate: 
        	return getHrSWInstalledDate();
        default:
          return super.getValue(column);
      }
    }
    
    public void setValue(int column, Variable value) {
     //--AgentGen BEGIN=hrSWInstalledEntry::RowSetValue
     //--AgentGen END
      switch(column) {
        case idxHrSWInstalledIndex: 
        	setHrSWInstalledIndex((Integer32)value);
        	break;
        case idxHrSWInstalledName: 
        	setHrSWInstalledName((OctetString)value);
        	break;
        case idxHrSWInstalledID: 
        	setHrSWInstalledID((OID)value);
        	break;
        case idxHrSWInstalledType: 
        	setHrSWInstalledType((Integer32)value);
        	break;
        case idxHrSWInstalledDate: 
        	setHrSWInstalledDate((OctetString)value);
        	break;
        default:
          super.setValue(column, value);
      }
    }

     //--AgentGen BEGIN=hrSWInstalledEntry::Row
     //--AgentGen END
  }
  
  class HrSWInstalledEntryRowFactory 
        implements MOTableRowFactory
  {
    public synchronized HrSWInstalledEntryRow createRow(OID index, Variable[] values)
        throws UnsupportedOperationException 
    {
      HrSWInstalledEntryRow row = 
        new HrSWInstalledEntryRow(index, values);
     //--AgentGen BEGIN=hrSWInstalledEntry::createRow
     //--AgentGen END
      return row;
    }

    @Override
    public void freeRow(MOTableRow moTableRow) {

    }

    public synchronized void freeRow(HrSWInstalledEntryRow row) {
     //--AgentGen BEGIN=hrSWInstalledEntry::freeRow
     //--AgentGen END
    }

     //--AgentGen BEGIN=hrSWInstalledEntry::RowFactory
     //--AgentGen END
  }


//--AgentGen BEGIN=_METHODS
//--AgentGen END

  // Textual Definitions of MIB module HostResourcesMib
  protected void addTCsToFactory(MOFactory moFactory) {
   moFactory.addTextualConvention(new InternationalDisplayString()); 
   moFactory.addTextualConvention(new KBytes()); 
   moFactory.addTextualConvention(new ProductID()); 
  }


  public class InternationalDisplayString implements TextualConvention {
  	
    public InternationalDisplayString() {
    }

    public String getModuleName() {
      return TC_MODULE_HOST_RESOURCES_MIB;
    }
  	
    public String getName() {
      return TC_INTERNATIONALDISPLAYSTRING;
    }
    
    public Variable createInitialValue() {
    	Variable v = new OctetString();
    	// further modify value to comply with TC constraints here:
     //--AgentGen BEGIN=InternationalDisplayString::createInitialValue
     //--AgentGen END
	    return v;
    }
  	
    public MOScalar createScalar(OID oid, MOAccess access, Variable value) {
      MOScalar scalar = moFactory.createScalar(oid, access, value);
     //--AgentGen BEGIN=InternationalDisplayString::createScalar
     //--AgentGen END
      return scalar;
    }
  	
    public MOColumn createColumn(int columnID, int syntax, MOAccess access,
                                 Variable defaultValue, boolean mutableInService) {
      MOColumn col = moFactory.createColumn(columnID, syntax, access, 
                                            defaultValue, mutableInService);
     //--AgentGen BEGIN=InternationalDisplayString::createColumn
     //--AgentGen END
      return col;      
    }
  }


  public class KBytes implements TextualConvention {
  	
    public KBytes() {
    }

    public String getModuleName() {
      return TC_MODULE_HOST_RESOURCES_MIB;
    }
  	
    public String getName() {
      return TC_KBYTES;
    }
    
    public Variable createInitialValue() {
    	Variable v = new Integer32();
      if (v instanceof AssignableFromLong) {
      	((AssignableFromLong)v).setValue(0L);
      }
    	// further modify value to comply with TC constraints here:
     //--AgentGen BEGIN=KBytes::createInitialValue
     //--AgentGen END
	    return v;
    }
  	
    public MOScalar createScalar(OID oid, MOAccess access, Variable value) {
      MOScalar scalar = moFactory.createScalar(oid, access, value);
      ValueConstraint vc = new ConstraintsImpl();
      ((ConstraintsImpl)vc).add(new Constraint(0L, 2147483647L));
      scalar.addMOValueValidationListener(new ValueConstraintValidator(vc));                                  
     //--AgentGen BEGIN=KBytes::createScalar
     //--AgentGen END
      return scalar;
    }
  	
    public MOColumn createColumn(int columnID, int syntax, MOAccess access,
                                 Variable defaultValue, boolean mutableInService) {
      MOColumn col = moFactory.createColumn(columnID, syntax, access, 
                                            defaultValue, mutableInService);
      if (col instanceof MOMutableColumn) {
        MOMutableColumn mcol = (MOMutableColumn)col;
        ValueConstraint vc = new ConstraintsImpl();
        ((ConstraintsImpl)vc).add(new Constraint(0L, 2147483647L));
        mcol.addMOValueValidationListener(new ValueConstraintValidator(vc));                                  
      }
     //--AgentGen BEGIN=KBytes::createColumn
     //--AgentGen END
      return col;      
    }
  }


  public class ProductID implements TextualConvention {
  	
    public ProductID() {
    }

    public String getModuleName() {
      return TC_MODULE_HOST_RESOURCES_MIB;
    }
  	
    public String getName() {
      return TC_PRODUCTID;
    }
    
    public Variable createInitialValue() {
    	Variable v = new OID();
    	// further modify value to comply with TC constraints here:
     //--AgentGen BEGIN=ProductID::createInitialValue
     //--AgentGen END
	    return v;
    }
  	
    public MOScalar createScalar(OID oid, MOAccess access, Variable value) {
      MOScalar scalar = moFactory.createScalar(oid, access, value);
     //--AgentGen BEGIN=ProductID::createScalar
     //--AgentGen END
      return scalar;
    }
  	
    public MOColumn createColumn(int columnID, int syntax, MOAccess access,
                                 Variable defaultValue, boolean mutableInService) {
      MOColumn col = moFactory.createColumn(columnID, syntax, access, 
                                            defaultValue, mutableInService);
     //--AgentGen BEGIN=ProductID::createColumn
     //--AgentGen END
      return col;      
    }
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_BEGIN
//--AgentGen END

  // Textual Definitions of other MIB modules
  public void addImportedTCsToFactory(MOFactory moFactory) {
   moFactory.addTextualConvention(new InterfaceIndexOrZero()); 
  }

  // Textual Convention InterfaceIndexOrZero from MIB module IF-MIB

  public class InterfaceIndexOrZero implements TextualConvention {
  	
    public InterfaceIndexOrZero() {
    }

    public String getModuleName() {
      return TC_MODULE_IF_MIB;
    }
  	
    public String getName() {
      return TC_INTERFACEINDEXORZERO;
    }
    
    public Variable createInitialValue() {
    	Variable v = new Integer32();
      if (v instanceof AssignableFromLong) {
      	((AssignableFromLong)v).setValue(0L);
      }
    	// further modify value to comply with TC constraints here:
     //--AgentGen BEGIN=InterfaceIndexOrZero::createInitialValue
     //--AgentGen END
	    return v;
    }
  	
    public MOScalar createScalar(OID oid, MOAccess access, Variable value) {
      MOScalar scalar = moFactory.createScalar(oid, access, value);
      ValueConstraint vc = new ConstraintsImpl();
      ((ConstraintsImpl)vc).add(new Constraint(0L, 2147483647L));
      scalar.addMOValueValidationListener(new ValueConstraintValidator(vc));                                  
     //--AgentGen BEGIN=InterfaceIndexOrZero::createScalar
     //--AgentGen END
      return scalar;
    }
  	
    public MOColumn createColumn(int columnID, int syntax, MOAccess access,
                                 Variable defaultValue, boolean mutableInService) {
      MOColumn col = moFactory.createColumn(columnID, syntax, access, 
                                            defaultValue, mutableInService);
      if (col instanceof MOMutableColumn) {
        MOMutableColumn mcol = (MOMutableColumn)col;
        ValueConstraint vc = new ConstraintsImpl();
        ((ConstraintsImpl)vc).add(new Constraint(0L, 2147483647L));
        mcol.addMOValueValidationListener(new ValueConstraintValidator(vc));                                  
      }
     //--AgentGen BEGIN=InterfaceIndexOrZero::createColumn
     //--AgentGen END
      return col;      
    }
  }


//--AgentGen BEGIN=_TC_CLASSES_IMPORTED_MODULES_END
//--AgentGen END

//--AgentGen BEGIN=_CLASSES
//--AgentGen END

//--AgentGen BEGIN=_END
//--AgentGen END
}


