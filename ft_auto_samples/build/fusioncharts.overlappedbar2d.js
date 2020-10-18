!function(e){"object"==typeof module&&"undefined"!=typeof module.exports?module.exports=e:e()}((function(){(window.webpackJsonpFusionCharts=window.webpackJsonpFusionCharts||[]).push([[11],{1175:function(e,t,a){"use strict";var i=a(187);t.__esModule=!0,t["default"]=void 0;var n=i(a(1176));t.OverlapperBar2D=n["default"];var l=i(a(1036)),r={name:"overlappedbar2d",type:"package",requiresFusionCharts:!0,extension:function(e){e.addDep(l["default"]),e.addDep(n["default"])}};t["default"]=r},1176:function(e,t,a){"use strict";var i=a(187);t.__esModule=!0,t["default"]=void 0;var n=i(a(1177))["default"];t["default"]=n},1177:function(e,t,a){"use strict";var i=a(187);t.__esModule=!0,t["default"]=void 0;var n=i(a(207)),l=i(a(518)),r=i(a(1178)),o=i(a(521)),s=i(a(1179)),d=function(e){function t(){var t;return(t=e.call(this)||this).isBar=!0,t.registerFactory("dataset",o["default"],["vCanvas"]),t}(0,n["default"])(t,e);var a=t.prototype;return a.__setDefaultConfig=function(){e.prototype.__setDefaultConfig.call(this);var t=this.config;t.friendlyName="Multi-series Bar Chart",t.hasLegend=!0,t.defaultDatasetType="bar2d"},a.getName=function(){return"OverlappedBar2D"},t.getName=function(){return"OverlappedBar2D"},a.getDSdef=function(){return r["default"]},a.getDSGroupdef=function(){return s["default"]},t}(l["default"]);t["default"]=d},1178:function(e,t,a){"use strict";var i=a(187);t.__esModule=!0,t["default"]=void 0;var n=i(a(207)),l=a(193),r=i(a(533)),o=l.preDefStr.visibleStr,s=l.preDefStr.hiddenStr,d=l.preDefStr.POSITION_MIDDLE,u=l.preDefStr.POSITION_START,f=l.preDefStr.POSITION_END,h=Math.max;function c(e,t){var a,i,n,l,r=e.x,o=e.width;for(a=0,i=t.length;a<i;a++)if(l=t[a].width,n=t[a].x,t[a].labelShown&&r+o>=n&&n+l>=r)return!0;return!1}var p=function(e){function t(){var t;return(t=e.call(this)||this)._labeldimensionMap={},t}return(0,n["default"])(t,e),t.prototype.drawLabel=function(){var e,t,a,i,n,r,p,b,g,v,S,m,D,_,w,x,y,k,N,C,M,O,I,T,L,B,F,A=this.getFromEnv("chart"),P=A.config,E=this.config,J=E.JSONData,R=this.getFromEnv("animationManager"),G=A.getChildren("canvas")[0].config,V=A.config.dataLabelStyle,K=J.data,j=A.config.categories,q=A.config.is3D,z=A.config.isstacked,H=j&&j.length,W=K&&K.length,Q=this.getData(),U=A.getFromEnv("smartLabel"),X=G.yDepth,Y=G.xDepth,Z=A.getFromEnv("number-formatter"),$=l.BLANKSTRING,ee=P.placevaluesinside,te=P.canvasWidth,ae=P.canvasLeft,ie=P.valuepadding+2,ne=this.getContainer("labelGroup"),le=this.getSkippingInfo&&this.getSkippingInfo(),re=le&&le.skippingApplied,oe=le&&le.labelDraw||[],se=oe.length,de=this.getJSONIndex(),ue=this.getState("visible"),fe=function(){this.hide()},he=function(){this.show()};for(ue&&ne.show(),U.setStyle(V),e=re?se:H<W?H:W,n=0;n<e;n++)x=(C=(t=Q[i=re?oe[n]:n])&&t.config)&&C.setValue,void 0!==t&&null!=x&&!0!==C.labelSkip?(p=t.graphics)&&(r=K[i],D=t._yPos,_=t._xPos,x=Z.getCleanValue(r.value),m=(0,l.pluckNumber)(x)<0,b=t._height,w=t._width,y=z?d:m?ee?u:f:ee?f:u,$=C.displayValue,L=p.label,C.showValue&&null!=$&&$!==l.BLANKSTRING&&null!==x?(a={text:$,fill:V.color,"text-bound":[V.backgroundColor,V.borderColor,V.borderThickness,V.borderPadding,V.borderRadius,V.borderDash],"line-height":V.lineHeight,visibility:this.getState("visible")?o:s},k=(B=U.getOriSize($)).width,k+=ie,N=ie,g=D+.5*b,v=_+(m?0:w),S=m?_-ae:ae+te-(_+w),ee?w>=k?(v+=m?N:-N,q&&(g+=X,v-=Y)):k<S?(v+=m?-N:N,y=m?f:u,q&&m&&(v-=Y)):m?(v=_+w+h(k-_-w+ae,0)-N,y=f):(v=_-h(k-(ae+te-_),0)+N,y=u):S>=k?(v+=m?-N:N,q&&m&&(v-=Y,g+=Y)):v+=m?N+k:-(N+k),(v>ae+te||v<ae)&&(v=ae+4,y=u),a["text-anchor"]=y,a.x=v,a.y=g,a["text-bound"]=[V.backgroundColor,V.borderColor,V.borderThickness,V.borderPadding,V.borderRadius,V.borderDash],a.opacity=ue?1:0,O=A.getDatasets().map((function(e){return e.getJSONIndex()<de&&e._labeldimensionMap[n]})).filter(Boolean),T=c(I={x:v,y:g,width:B.width,height:B.height},O),this._labeldimensionMap[n]=I,T?p.label&&(p.label=R.setAnimation({el:p.label,component:this}),this._labeldimensionMap[n].labelShown=!1):((M=R.setAnimation({el:L||"text",container:ne,component:this,attr:a,callback:ue?he:fe,label:"plotLabel"}))&&M.outlineText(E.showTextOutline,a.fill),L||(p.label=M)),this._labeldimensionMap[n].labelShown=!(!ue||T)):p.label&&(p.label=R.setAnimation({el:p.label,component:this}),this._labeldimensionMap[n].labelShown=!1)):((F=t&&t.graphics)&&F.label&&F.label.hide(),C&&delete C.labelSkip)},t}(r["default"]);t["default"]=p}}])}));
//# sourceMappingURL=http://localhost:3052/3.15.1-rc.3/map/eval/fusioncharts.overlappedbar2d.js.map