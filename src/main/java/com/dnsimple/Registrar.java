package com.dnsimple;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import com.dnsimple.response.CheckDomainResponse;
import com.dnsimple.response.RegisterDomainResponse;
import com.dnsimple.response.RenewDomainResponse;
import com.dnsimple.response.TransferDomainResponse;
import com.dnsimple.response.TransferDomainOutResponse;

import com.dnsimple.exception.DnsimpleException;
import com.dnsimple.exception.ResourceNotFoundException;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;

/**
 * Provides access to the DNSimple Registrar API.
 *
 * @see https://developer.dnsimple.com/v2/registrar
 */
public class Registrar {
  private Client client;

  protected Registrar(Client client) {
    this.client = client;
  }

  /**
   * Checks whether a domain is available for registration.
   *
   * @see https://developer.dnsimple.com/v2/registrar/#check
   */
  public CheckDomainResponse checkDomain(String accountId, String domainName) throws DnsimpleException, IOException {
    HttpResponse response = client.get(accountId + "/registrar/domains/" + domainName + "/check");
    return (CheckDomainResponse)client.parseResponse(response, CheckDomainResponse.class);
  }

  public RegisterDomainResponse registerDomain(String accountId, String domainName, Map<String,Object> attributes) throws DnsimpleException, IOException {
    HttpResponse response = client.post(accountId + "/registrar/domains/" + domainName + "/register", attributes);
    return (RegisterDomainResponse)client.parseResponse(response, RegisterDomainResponse.class);
  }

  public RenewDomainResponse renewDomain(String accountId, String domainName, Map<String,Object> attributes) throws DnsimpleException, IOException {
    HttpResponse response = client.post(accountId + "/registrar/domains/" + domainName + "/renewal", attributes);
    return (RenewDomainResponse)client.parseResponse(response, RenewDomainResponse.class);
  }

  public TransferDomainResponse transferDomain(String accountId, String domainName, Map<String,Object> attributes) throws DnsimpleException, IOException {
    HttpResponse response = client.post(accountId + "/registrar/domains/" + domainName + "/transfer", attributes);
    return (TransferDomainResponse)client.parseResponse(response, TransferDomainResponse.class);
  }

  public TransferDomainOutResponse transferDomainOut(String accountId, String domainName) throws DnsimpleException, IOException {
    HttpResponse response = client.post(accountId + "/registrar/domains/" + domainName + "/transfer_out");
    return (TransferDomainOutResponse)client.parseResponse(response, TransferDomainOutResponse.class);
  }
}
