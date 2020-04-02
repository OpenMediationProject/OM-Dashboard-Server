FROM adtiming/ombuilder as builder
ARG BUILDER_URL="https://github.com/AdTiming/OM-Dashboard-Server.git"
ARG BUILDER_DIR="OM-Dashboard-Server"
RUN git clone ${BUILDER_URL} && \
    cd ${BUILDER_DIR} && \
    mvn clean package -Dmaven.test.skip=true

FROM adtiming/omjava
MAINTAINER openmediation
ENV SYSTEMNAME "omsystem"
ENV SERVERNAME "om-ds-server"
ARG GET_BUILDER_DIR="/data/OM-Dashboard-Server"
RUN mkdir -p /${SERVERNAME}/log 
ADD docker-entrypoint.sh /
ADD application-loc.yml /${SERVERNAME}/
COPY --from=builder ${GET_BUILDER_DIR}/target/${SERVERNAME}.jar /${SERVERNAME}/
WORKDIR /
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:19013/api/check || exit 1
EXPOSE 19013
ENTRYPOINT ["/docker-entrypoint.sh"] 
CMD ["om-ds-server"]
