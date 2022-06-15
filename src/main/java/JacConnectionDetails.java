/**
 * Envs for CARINA .
 */
public enum JacConnectionDetails
{

  C0("carinac0cam", "jact1.airnz.co.nz", 30072),
  D0("carinad0cam", "jact1.airnz.co.nz", 30072),
  Q0("carinaq0cam", "jacq1.airnz.co.nz", 30074);

  private final String jacName;

  private final String jacUrl;

  private final Integer jacPort;

  JacConnectionDetails(String jacName, String jacUrl, Integer jacPort)
  {
    this.jacName = jacName;
    this.jacUrl = jacUrl;
    this.jacPort = jacPort;
  }

  public String getJacName()
  {
    return jacName;
  }

  public String getJacUrl()
  {
    return jacUrl;
  }

  public int getJacPort()
  {
    return jacPort;
  }

  /**
   * Find matching environment(d0/c0/q0/a0) item for the given string.
   *
   * @param enumAsString Input from consumer
   * @return Matching Jac details
   */
  public static JacConnectionDetails checkEnvironment(String enumAsString)
  {
    for (JacConnectionDetails singleItem : values())
    {
      if (singleItem.name().equalsIgnoreCase(enumAsString))
      {
        return singleItem;
      }
    }
    throw new IllegalArgumentException("END-TO-END Test not available for environment:" + enumAsString);
  }

}
