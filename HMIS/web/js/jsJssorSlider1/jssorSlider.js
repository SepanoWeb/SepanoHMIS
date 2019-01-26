(function (f, g, c, j, d, k, l) {/*! Jssor */
    new (function () {
    });
    var e = {zc: function (a) {
            return-c.cos(a * c.PI) / 2 + .5
        }, Dc: function (a) {
            return a
        }, Gf: function (a) {
            return a * a
        }, Jc: function (a) {
            return-a * (a - 2)
        }, Ff: function (a) {
            return(a *= 2) < 1 ? 1 / 2 * a * a : -1 / 2 * (--a * (a - 2) - 1)
        }, Ef: function (a) {
            return a * a * a
        }, Df: function (a) {
            return(a -= 1) * a * a + 1
        }, Cf: function (a) {
            return(a *= 2) < 1 ? 1 / 2 * a * a * a : 1 / 2 * ((a -= 2) * a * a + 2)
        }, Bf: function (a) {
            return a * a * a * a
        }, Hf: function (a) {
            return-((a -= 1) * a * a * a - 1)
        }, Af: function (a) {
            return(a *= 2) < 1 ? 1 / 2 * a * a * a * a : -1 / 2 * ((a -= 2) * a * a * a - 2)
        }, yf: function (a) {
            return a * a * a * a * a
        }, xf: function (a) {
            return(a -= 1) * a * a * a * a + 1
        }, wf: function (a) {
            return(a *= 2) < 1 ? 1 / 2 * a * a * a * a * a : 1 / 2 * ((a -= 2) * a * a * a * a + 2)
        }, vf: function (a) {
            return 1 - c.cos(c.PI / 2 * a)
        }, uf: function (a) {
            return c.sin(c.PI / 2 * a)
        }, tf: function (a) {
            return-1 / 2 * (c.cos(c.PI * a) - 1)
        }, zf: function (a) {
            return a == 0 ? 0 : c.pow(2, 10 * (a - 1))
        }, Jf: function (a) {
            return a == 1 ? 1 : -c.pow(2, -10 * a) + 1
        }, Rf: function (a) {
            return a == 0 || a == 1 ? a : (a *= 2) < 1 ? 1 / 2 * c.pow(2, 10 * (a - 1)) : 1 / 2 * (-c.pow(2, -10 * --a) + 2)
        }, Kf: function (a) {
            return-(c.sqrt(1 - a * a) - 1)
        }, Yf: function (a) {
            return c.sqrt(1 - (a -= 1) * a)
        }, Xf: function (a) {
            return(a *= 2) < 1 ? -1 / 2 * (c.sqrt(1 - a * a) - 1) : 1 / 2 * (c.sqrt(1 - (a -= 2) * a) + 1)
        }, Wf: function (a) {
            if (!a || a == 1)
                return a;
            var b = .3, d = .075;
            return-(c.pow(2, 10 * (a -= 1)) * c.sin((a - d) * 2 * c.PI / b))
        }, Vf: function (a) {
            if (!a || a == 1)
                return a;
            var b = .3, d = .075;
            return c.pow(2, -10 * a) * c.sin((a - d) * 2 * c.PI / b) + 1
        }, Uf: function (a) {
            if (!a || a == 1)
                return a;
            var b = .45, d = .1125;
            return(a *= 2) < 1 ? -.5 * c.pow(2, 10 * (a -= 1)) * c.sin((a - d) * 2 * c.PI / b) : c.pow(2, -10 * (a -= 1)) * c.sin((a - d) * 2 * c.PI / b) * .5 + 1
        }, Tf: function (a) {
            var b = 1.70158;
            return a * a * ((b + 1) * a - b)
        }, Zf: function (a) {
            var b = 1.70158;
            return(a -= 1) * a * ((b + 1) * a + b) + 1
        }, Sf: function (a) {
            var b = 1.70158;
            return(a *= 2) < 1 ? 1 / 2 * a * a * (((b *= 1.525) + 1) * a - b) : 1 / 2 * ((a -= 2) * a * (((b *= 1.525) + 1) * a + b) + 2)
        }, Wc: function (a) {
            return 1 - e.pc(1 - a)
        }, pc: function (a) {
            return a < 1 / 2.75 ? 7.5625 * a * a : a < 2 / 2.75 ? 7.5625 * (a -= 1.5 / 2.75) * a + .75 : a < 2.5 / 2.75 ? 7.5625 * (a -= 2.25 / 2.75) * a + .9375 : 7.5625 * (a -= 2.625 / 2.75) * a + .984375
        }, Qf: function (a) {
            return a < 1 / 2 ? e.Wc(a * 2) * .5 : e.pc(a * 2 - 1) * .5 + .5
        }, Pf: function () {
            return 1 - c.abs(1)
        }, Of: function (a) {
            return 1 - c.cos(a * c.PI * 2)
        }, Nf: function (a) {
            return c.sin(a * c.PI * 2)
        }, Mf: function (a) {
            return 1 - ((a *= 2) < 1 ? (a = 1 - a) * a * a : (a -= 1) * a * a)
        }, Lf: function (a) {
            return(a *= 2) < 1 ? a * a * a : (a = 2 - a) * a * a
        }}, h = {sf: e.zc, rf: e.Dc, qf: e.Gf, gf: e.Jc, Je: e.Ff, Ke: e.Ef, Le: e.Df, Me: e.Cf, Ne: e.Bf, Oe: e.Hf, Pe: e.Af, Qe: e.yf, Re: e.xf, Se: e.wf, Te: e.vf, Ue: e.uf, Ve: e.tf, We: e.zf, Xe: e.Jf, Ye: e.Rf, Ze: e.Kf, of: e.Yf, nf: e.Xf, mf: e.Wf, lf: e.Vf, kf: e.Uf, jf: e.Tf, pf: e.Zf, hf: e.Sf, ff: e.Wc, ef: e.pc, df: e.Qf, bg: e.Pf, bf: e.Of, af: e.Nf, If: e.Mf, ag: e.Lf};
    var b = new function () {
        var h = this, Ab = /\S+/g, F = 1, yb = 2, fb = 3, eb = 4, jb = 5, G, r = 0, i = 0, s = 0, X = 0, z = 0, I = navigator, ob = I.appName, o = I.userAgent, p = parseFloat;
        function Ib() {
            if (!G) {
                G = {Eg: "ontouchstart"in f || "createTouch"in g};
                var a;
                if (I.pointerEnabled || (a = I.msPointerEnabled))
                    G.hd = a ? "msTouchAction" : "touchAction"
            }
            return G
        }
        function v(j) {
            if (!r) {
                r = -1;
                if (ob == "Microsoft Internet Explorer" && !!f.attachEvent && !!f.ActiveXObject) {
                    var e = o.indexOf("MSIE");
                    r = F;
                    s = p(o.substring(e + 5, o.indexOf(";", e)));/*@cc_on X=@_jscript_version@*/
                    ;
                    i = g.documentMode || s
                } else if (ob == "Netscape" && !!f.addEventListener) {
                    var d = o.indexOf("Firefox"), b = o.indexOf("Safari"), h = o.indexOf("Chrome"), c = o.indexOf("AppleWebKit");
                    if (d >= 0) {
                        r = yb;
                        i = p(o.substring(d + 8))
                    } else if (b >= 0) {
                        var k = o.substring(0, b).lastIndexOf("/");
                        r = h >= 0 ? eb : fb;
                        i = p(o.substring(k + 1, b))
                    } else {
                        var a = /Trident\/.*rv:([0-9]{1,}[\.0-9]{0,})/i.exec(o);
                        if (a) {
                            r = F;
                            i = s = p(a[1])
                        }
                    }
                    if (c >= 0)
                        z = p(o.substring(c + 12))
                } else {
                    var a = /(opera)(?:.*version|)[ \/]([\w.]+)/i.exec(o);
                    if (a) {
                        r = jb;
                        i = p(a[2])
                    }
                }
            }
            return j == r
        }
        function q() {
            return v(F)
        }
        function Q() {
            return q() && (i < 6 || g.compatMode == "BackCompat")
        }
        function db() {
            return v(fb)
        }
        function ib() {
            return v(jb)
        }
        function vb() {
            return db() && z > 534 && z < 535
        }
        function J() {
            v();
            return z > 537 || i > 42 || r == F && i >= 11
        }
        function O() {
            return q() && i < 9
        }
        function wb(a) {
            var b, c;
            return function (f) {
                if (!b) {
                    b = d;
                    var e = a.substr(0, 1).toUpperCase() + a.substr(1);
                    n([a].concat(["WebKit", "ms", "Moz", "O", "webkit"]), function (g, d) {
                        var b = a;
                        if (d)
                            b = g + e;
                        if (f.style[b] != l)
                            return c = b
                    })
                }
                return c
            }
        }
        function ub(b) {
            var a;
            return function (c) {
                a = a || wb(b)(c) || b;
                return a
            }
        }
        var K = ub("transform");
        function nb(a) {
            return{}.toString.call(a)
        }
        var kb = {};
        n(["Boolean", "Number", "String", "Function", "Array", "Date", "RegExp", "Object"], function (a) {
            kb["[object " + a + "]"] = a.toLowerCase()
        });
        function n(b, d) {
            var a, c;
            if (nb(b) == "[object Array]") {
                for (a = 0; a < b.length; a++)
                    if (c = d(b[a], a, b))
                        return c
            } else
                for (a in b)
                    if (c = d(b[a], a, b))
                        return c
        }
        function C(a) {
            return a == j ? String(a) : kb[nb(a)] || "object"
        }
        function lb(a) {
            for (var b in a)
                return d
        }
        function A(a) {
            try {
                return C(a) == "object" && !a.nodeType && a != a.window && (!a.constructor || {}.hasOwnProperty.call(a.constructor.prototype, "isPrototypeOf"))
            } catch (b) {
            }
        }
        function u(a, b) {
            return{x: a, y: b}
        }
        function rb(b, a) {
            setTimeout(b, a || 0)
        }
        function H(b, d, c) {
            var a = !b || b == "inherit" ? "" : b;
            n(d, function (c) {
                var b = c.exec(a);
                if (b) {
                    var d = a.substr(0, b.index), e = a.substr(b.index + b[0].length + 1, a.length - 1);
                    a = d + e
                }
            });
            a = c + (!a.indexOf(" ") ? "" : " ") + a;
            return a
        }
        function tb(b, a) {
            if (i < 9)
                b.style.filter = a
        }
        h.yg = Ib;
        h.wd = q;
        h.gg = db;
        h.xd = ib;
        h.jg = J;
        h.nb = O;
        wb("transform");
        h.Id = function () {
            return i
        };
        h.ng = function () {
            v();
            return z
        };
        h.Fb = rb;
        function Y(a) {
            a.constructor === Y.caller && a.Dd && a.Dd.apply(a, Y.caller.arguments)
        }
        h.Dd = Y;
        h.pb = function (a) {
            if (h.og(a))
                a = g.getElementById(a);
            return a
        };
        function t(a) {
            return a || f.event
        }
        h.Bd = t;
        h.cc = function (b) {
            b = t(b);
            var a = b.target || b.srcElement || g;
            if (a.nodeType == 3)
                a = h.Ad(a);
            return a
        };
        h.ed = function (a) {
            a = t(a);
            return{x: a.pageX || a.clientX || 0, y: a.pageY || a.clientY || 0}
        };
        function D(c, d, a) {
            if (a !== l)
                c.style[d] = a == l ? "" : a;
            else {
                var b = c.currentStyle || c.style;
                a = b[d];
                if (a == "" && f.getComputedStyle) {
                    b = c.ownerDocument.defaultView.getComputedStyle(c, j);
                    b && (a = b.getPropertyValue(d) || b[d])
                }
                return a
            }
        }
        function ab(b, c, a, d) {
            if (a !== l) {
                if (a == j)
                    a = "";
                else
                    d && (a += "px");
                D(b, c, a)
            } else
                return p(D(b, c))
        }
        function m(c, a) {
            var d = a ? ab : D, b;
            if (a & 4)
                b = ub(c);
            return function (e, f) {
                return d(e, b ? b(e) : c, f, a & 2)
            }
        }
        function Db(b) {
            if (q() && s < 9) {
                var a = /opacity=([^)]*)/.exec(b.style.filter || "");
                return a ? p(a[1]) / 100 : 1
            } else
                return p(b.style.opacity || "1")
        }
        function Fb(b, a, f) {
            if (q() && s < 9) {
                var h = b.style.filter || "", i = new RegExp(/[\s]*alpha\([^\)]*\)/g), e = c.round(100 * a), d = "";
                if (e < 100 || f)
                    d = "alpha(opacity=" + e + ") ";
                var g = H(h, [i], d);
                tb(b, g)
            } else
                b.style.opacity = a == 1 ? "" : c.round(a * 100) / 100
        }
        var L = {Q: ["rotate"], Z: ["rotateX"], Y: ["rotateY"], Qb: ["skewX"], Nb: ["skewY"]};
        if (!J())
            L = B(L, {A: ["scaleX", 2], D: ["scaleY", 2], V: ["translateZ", 1]});
        function M(d, a) {
            var c = "";
            if (a) {
                if (q() && i && i < 10) {
                    delete a.Z;
                    delete a.Y;
                    delete a.V
                }
                b.a(a, function (d, b) {
                    var a = L[b];
                    if (a) {
                        var e = a[1] || 0;
                        if (N[b] != d)
                            c += " " + a[0] + "(" + d + (["deg", "px", ""])[e] + ")"
                    }
                });
                if (J()) {
                    if (a.jb || a.kb || a.V)
                        c += " translate3d(" + (a.jb || 0) + "px," + (a.kb || 0) + "px," + (a.V || 0) + "px)";
                    if (a.A == l)
                        a.A = 1;
                    if (a.D == l)
                        a.D = 1;
                    if (a.A != 1 || a.D != 1)
                        c += " scale3d(" + a.A + ", " + a.D + ", 1)"
                }
            }
            d.style[K(d)] = c
        }
        h.Hc = m("transformOrigin", 4);
        h.sg = m("backfaceVisibility", 4);
        h.tg = m("transformStyle", 4);
        h.ug = m("perspective", 6);
        h.vg = m("perspectiveOrigin", 4);
        h.wg = function (a, b) {
            if (q() && s < 9 || s < 10 && Q())
                a.style.zoom = b == 1 ? "" : b;
            else {
                var c = K(a), f = "scale(" + b + ")", e = a.style[c], g = new RegExp(/[\s]*scale\(.*?\)/g), d = H(e, [g], f);
                a.style[c] = d
            }
        };
        h.hc = function (b, a) {
            return function (c) {
                c = t(c);
                var e = c.type, d = c.relatedTarget || (e == "mouseout" ? c.toElement : c.fromElement);
                (!d || d !== a && !h.Ng(a, d)) && b(c)
            }
        };
        h.c = function (a, d, b, c) {
            a = h.pb(a);
            if (a.addEventListener) {
                d == "mousewheel" && a.addEventListener("DOMMouseScroll", b, c);
                a.addEventListener(d, b, c)
            } else if (a.attachEvent) {
                a.attachEvent("on" + d, b);
                c && a.setCapture && a.setCapture()
            }
        };
        h.M = function (a, c, d, b) {
            a = h.pb(a);
            if (a.removeEventListener) {
                c == "mousewheel" && a.removeEventListener("DOMMouseScroll", d, b);
                a.removeEventListener(c, d, b)
            } else if (a.detachEvent) {
                a.detachEvent("on" + c, d);
                b && a.releaseCapture && a.releaseCapture()
            }
        };
        h.Ub = function (a) {
            a = t(a);
            a.preventDefault && a.preventDefault();
            a.cancel = d;
            a.returnValue = k
        };
        h.mg = function (a) {
            a = t(a);
            a.stopPropagation && a.stopPropagation();
            a.cancelBubble = d
        };
        h.P = function (d, c) {
            var a = [].slice.call(arguments, 2), b = function () {
                var b = a.concat([].slice.call(arguments, 0));
                return c.apply(d, b)
            };
            return b
        };
        h.rg = function (a, b) {
            if (b == l)
                return a.textContent || a.innerText;
            var c = g.createTextNode(b);
            h.bc(a);
            a.appendChild(c)
        };
        h.xb = function (d, c) {
            for (var b = [], a = d.firstChild; a; a = a.nextSibling)
                (c || a.nodeType == 1) && b.push(a);
            return b
        };
        function mb(a, c, e, b) {
            b = b || "u";
            for (a = a?a.firstChild:j; a; a = a.nextSibling)
                if (a.nodeType == 1) {
                    if (U(a, b) == c)
                        return a;
                    if (!e) {
                        var d = mb(a, c, e, b);
                        if (d)
                            return d
                    }
                }
        }
        h.I = mb;
        function S(a, d, f, b) {
            b = b || "u";
            var c = [];
            for (a = a?a.firstChild:j; a; a = a.nextSibling)
                if (a.nodeType == 1) {
                    U(a, b) == d && c.push(a);
                    if (!f) {
                        var e = S(a, d, f, b);
                        if (e.length)
                            c = c.concat(e)
                    }
                }
            return c
        }
        function gb(a, c, d) {
            for (a = a?a.firstChild:j; a; a = a.nextSibling)
                if (a.nodeType == 1) {
                    if (a.tagName == c)
                        return a;
                    if (!d) {
                        var b = gb(a, c, d);
                        if (b)
                            return b
                    }
                }
        }
        h.He = gb;
        function xb(a, c, e) {
            var b = [];
            for (a = a?a.firstChild:j; a; a = a.nextSibling)
                if (a.nodeType == 1) {
                    (!c || a.tagName == c) && b.push(a);
                    if (!e) {
                        var d = xb(a, c, e);
                        if (d.length)
                            b = b.concat(d)
                    }
                }
            return b
        }
        h.lg = xb;
        h.kg = function (b, a) {
            return b.getElementsByTagName(a)
        };
        function B() {
            var e = arguments, d, c, b, a, g = 1 & e[0], f = 1 + g;
            d = e[f - 1] || {};
            for (; f < e.length; f++)
                if (c = e[f])
                    for (b in c) {
                        a = c[b];
                        if (a !== l) {
                            a = c[b];
                            var h = d[b];
                            d[b] = g && (A(h) || A(a)) ? B(g, {}, h, a) : a
                        }
                    }
            return d
        }
        h.p = B;
        function Z(f, g) {
            var d = {}, c, a, b;
            for (c in f) {
                a = f[c];
                b = g[c];
                if (a !== b) {
                    var e;
                    if (A(a) && A(b)) {
                        a = Z(a, b);
                        e = !lb(a)
                    }
                    !e && (d[c] = a)
                }
            }
            return d
        }
        h.Fd = function (a) {
            return C(a) == "function"
        };
        h.og = function (a) {
            return C(a) == "string"
        };
        h.Jb = function (a) {
            return!isNaN(p(a)) && isFinite(a)
        };
        h.a = n;
        h.Rc = A;
        function R(a) {
            return g.createElement(a)
        }
        h.Tb = function () {
            return R("DIV")
        };
        h.eg = function () {
            return R("SPAN")
        };
        h.bd = function () {
        };
        function V(b, c, a) {
            if (a == l)
                return b.getAttribute(c);
            b.setAttribute(c, a)
        }
        function U(a, b) {
            return V(a, b) || V(a, "data-" + b)
        }
        h.q = V;
        h.j = U;
        function x(b, a) {
            if (a == l)
                return b.className;
            b.className = a
        }
        h.Yc = x;
        function qb(b) {
            var a = {};
            n(b, function (b) {
                a[b] = b
            });
            return a
        }
        function sb(b, a) {
            return b.match(a || Ab)
        }
        function P(b, a) {
            return qb(sb(b || "", a))
        }
        h.zg = sb;
        function bb(b, c) {
            var a = "";
            n(c, function (c) {
                a && (a += b);
                a += c
            });
            return a
        }
        function E(a, c, b) {
            x(a, bb(" ", B(Z(P(x(a)), P(c)), P(b))))
        }
        h.Ad = function (a) {
            return a.parentNode
        };
        h.T = function (a) {
            h.X(a, "none")
        };
        h.E = function (a, b) {
            h.X(a, b ? "none" : "")
        };
        h.Kg = function (b, a) {
            b.removeAttribute(a)
        };
        h.Ig = function () {
            return q() && i < 10
        };
        h.Ie = function (d, a) {
            if (a)
                d.style.clip = "rect(" + c.round(a.g || a.B || 0) + "px " + c.round(a.o) + "px " + c.round(a.n) + "px " + c.round(a.f || a.C || 0) + "px)";
            else if (a !== l) {
                var g = d.style.cssText, f = [new RegExp(/[\s]*clip: rect\(.*?\)[;]?/i), new RegExp(/[\s]*cliptop: .*?[;]?/i), new RegExp(/[\s]*clipright: .*?[;]?/i), new RegExp(/[\s]*clipbottom: .*?[;]?/i), new RegExp(/[\s]*clipleft: .*?[;]?/i)], e = H(g, f, "");
                b.Kb(d, e)
            }
        };
        h.U = function () {
            return+new Date
        };
        h.R = function (b, a) {
            b.appendChild(a)
        };
        h.Mb = function (b, a, c) {
            (c || a.parentNode).insertBefore(b, a)
        };
        h.Gb = function (b, a) {
            a = a || b.parentNode;
            a && a.removeChild(b)
        };
        h.Ud = function (a, b) {
            n(a, function (a) {
                h.Gb(a, b)
            })
        };
        h.bc = function (a) {
            h.Ud(h.xb(a, d), a)
        };
        h.Sd = function (a, b) {
            var c = h.Ad(a);
            b & 1 && h.H(a, (h.l(c) - h.l(a)) / 2);
            b & 2 && h.K(a, (h.m(c) - h.m(a)) / 2)
        };
        h.ac = function (b, a) {
            return parseInt(b, a || 10)
        };
        h.Vd = p;
        h.Ng = function (b, a) {
            var c = g.body;
            while (a && b !== a && c !== a)
                try {
                    a = a.parentNode
                } catch (d) {
                    return k
                }
            return b === a
        };
        function W(d, c, b) {
            var a = d.cloneNode(!c);
            !b && h.Kg(a, "id");
            return a
        }
        h.ab = W;
        h.yb = function (e, f) {
            var a = new Image;
            function b(e, d) {
                h.M(a, "load", b);
                h.M(a, "abort", c);
                h.M(a, "error", c);
                f && f(a, d)
            }
            function c(a) {
                b(a, d)
            }
            if (ib() && i < 11.6 || !e)
                b(!e);
            else {
                h.c(a, "load", b);
                h.c(a, "abort", c);
                h.c(a, "error", c);
                a.src = e
            }
        };
        h.Fe = function (d, a, e) {
            var c = d.length + 1;
            function b(b) {
                c--;
                if (a && b && b.src == a.src)
                    a = b;
                !c && e && e(a)
            }
            n(d, function (a) {
                h.yb(a.src, b)
            });
            b()
        };
        h.Xd = function (a, g, i, h) {
            if (h)
                a = W(a);
            var c = S(a, g);
            if (!c.length)
                c = b.kg(a, g);
            for (var f = c.length - 1; f > -1; f--) {
                var d = c[f], e = W(i);
                x(e, x(d));
                b.Kb(e, d.style.cssText);
                b.Mb(e, d);
                b.Gb(d)
            }
            return a
        };
        function Gb(a) {
            var k = this, p = "", r = ["av", "pv", "ds", "dn"], e = [], q, j = 0, f = 0, d = 0;
            function i() {
                E(a, q, e[d || j || f & 2 || f]);
                b.bb(a, "pointer-events", d ? "none" : "")
            }
            function c() {
                j = 0;
                i();
                h.M(g, "mouseup", c);
                h.M(g, "touchend", c);
                h.M(g, "touchcancel", c)
            }
            function o(a) {
                if (d)
                    h.Ub(a);
                else {
                    j = 4;
                    i();
                    h.c(g, "mouseup", c);
                    h.c(g, "touchend", c);
                    h.c(g, "touchcancel", c)
                }
            }
            k.re = function (a) {
                if (a === l)
                    return f;
                f = a & 2 || a & 1;
                i()
            };
            k.Oc = function (a) {
                if (a === l)
                    return!d;
                d = a ? 0 : 3;
                i()
            };
            k.db = a = h.pb(a);
            var m = b.zg(x(a));
            if (m)
                p = m.shift();
            n(r, function (a) {
                e.push(p + a)
            });
            q = bb(" ", e);
            e.unshift("");
            h.c(a, "mousedown", o);
            h.c(a, "touchstart", o)
        }
        h.gc = function (a) {
            return new Gb(a)
        };
        h.bb = D;
        h.Ab = m("overflow");
        h.K = m("top", 2);
        h.H = m("left", 2);
        h.l = m("width", 2);
        h.m = m("height", 2);
        h.Ce = m("marginLeft", 2);
        h.Wd = m("marginTop", 2);
        h.r = m("position");
        h.X = m("display");
        h.v = m("zIndex", 1);
        h.Db = function (b, a, c) {
            if (a != l)
                Fb(b, a, c);
            else
                return Db(b)
        };
        h.Kb = function (a, b) {
            if (b != l)
                a.style.cssText = b;
            else
                return a.style.cssText
        };
        var T = {L: h.Db, g: h.K, f: h.H, N: h.l, O: h.m, tb: h.r, Vg: h.X, S: h.v};
        function w(f, k) {
            var e = O(), b = J(), d = vb(), g = K(f);
            function i(b, d, a) {
                var e = b.ib(u(-d / 2, -a / 2)), f = b.ib(u(d / 2, -a / 2)), g = b.ib(u(d / 2, a / 2)), h = b.ib(u(-d / 2, a / 2));
                b.ib(u(300, 300));
                return u(c.min(e.x, f.x, g.x, h.x) + d / 2, c.min(e.y, f.y, g.y, h.y) + a / 2)
            }
            function a(d, a) {
                a = a || {};
                var n = a.V || 0, p = (a.Z || 0) % 360, q = (a.Y || 0) % 360, u = (a.Q || 0) % 360, k = a.A, m = a.D, f = a.Ug;
                if (k == l)
                    k = 1;
                if (m == l)
                    m = 1;
                if (f == l)
                    f = 1;
                if (e) {
                    n = 0;
                    p = 0;
                    q = 0;
                    f = 0
                }
                var c = new Cb(a.jb, a.kb, n);
                c.Z(p);
                c.Y(q);
                c.ce(u);
                c.de(a.Qb, a.Nb);
                c.dc(k, m, f);
                if (b) {
                    c.gb(a.C, a.B);
                    d.style[g] = c.fe()
                } else if (!X || X < 9) {
                    var o = "", j = {x: 0, y: 0};
                    if (a.cb)
                        j = i(c, a.cb, a.mb);
                    h.Wd(d, j.y);
                    h.Ce(d, j.x);
                    o = c.he();
                    var s = d.style.filter, t = new RegExp(/[\s]*progid:DXImageTransform\.Microsoft\.Matrix\([^\)]*\)/g), r = H(s, [t], o);
                    tb(d, r)
                }
            }
            w = function (e, c) {
                c = c || {};
                var g = c.C, i = c.B, f;
                n(T, function (a, b) {
                    f = c[b];
                    f !== l && a(e, f)
                });
                h.Ie(e, c.e);
                if (!b) {
                    g != l && h.H(e, (c.kd || 0) + g);
                    i != l && h.K(e, (c.ld || 0) + i)
                }
                if (c.je)
                    if (d)
                        rb(h.P(j, M, e, c));
                    else
                        a(e, c)
            };
            h.rb = M;
            if (d)
                h.rb = w;
            if (e)
                h.rb = a;
            else if (!b)
                a = M;
            h.F = w;
            w(f, k)
        }
        h.rb = w;
        h.F = w;
        function Cb(i, k, o) {
            var d = this, b = [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, i || 0, k || 0, o || 0, 1], h = c.sin, g = c.cos, l = c.tan;
            function f(a) {
                return a * c.PI / 180
            }
            function n(a, b) {
                return{x: a, y: b}
            }
            function m(c, e, l, m, o, r, t, u, w, z, A, C, E, b, f, k, a, g, i, n, p, q, s, v, x, y, B, D, F, d, h, j) {
                return[c * a + e * p + l * x + m * F, c * g + e * q + l * y + m * d, c * i + e * s + l * B + m * h, c * n + e * v + l * D + m * j, o * a + r * p + t * x + u * F, o * g + r * q + t * y + u * d, o * i + r * s + t * B + u * h, o * n + r * v + t * D + u * j, w * a + z * p + A * x + C * F, w * g + z * q + A * y + C * d, w * i + z * s + A * B + C * h, w * n + z * v + A * D + C * j, E * a + b * p + f * x + k * F, E * g + b * q + f * y + k * d, E * i + b * s + f * B + k * h, E * n + b * v + f * D + k * j]
            }
            function e(c, a) {
                return m.apply(j, (a || b).concat(c))
            }
            d.dc = function (a, c, d) {
                if (a != 1 || c != 1 || d != 1)
                    b = e([a, 0, 0, 0, 0, c, 0, 0, 0, 0, d, 0, 0, 0, 0, 1])
            };
            d.gb = function (a, c, d) {
                b[12] += a || 0;
                b[13] += c || 0;
                b[14] += d || 0
            };
            d.Z = function (c) {
                if (c) {
                    a = f(c);
                    var d = g(a), i = h(a);
                    b = e([1, 0, 0, 0, 0, d, i, 0, 0, -i, d, 0, 0, 0, 0, 1])
                }
            };
            d.Y = function (c) {
                if (c) {
                    a = f(c);
                    var d = g(a), i = h(a);
                    b = e([d, 0, -i, 0, 0, 1, 0, 0, i, 0, d, 0, 0, 0, 0, 1])
                }
            };
            d.ce = function (c) {
                if (c) {
                    a = f(c);
                    var d = g(a), i = h(a);
                    b = e([d, i, 0, 0, -i, d, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1])
                }
            };
            d.de = function (a, c) {
                if (a || c) {
                    i = f(a);
                    k = f(c);
                    b = e([1, l(k), 0, 0, l(i), 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1])
                }
            };
            d.ib = function (c) {
                var a = e(b, [1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, c.x, c.y, 0, 1]);
                return n(a[12], a[13])
            };
            d.fe = function () {
                return"matrix3d(" + b.join(",") + ")"
            };
            d.he = function () {
                return"progid:DXImageTransform.Microsoft.Matrix(M11=" + b[0] + ", M12=" + b[4] + ", M21=" + b[1] + ", M22=" + b[5] + ", SizingMethod='auto expand')"
            }
        }
        new function () {
            var a = this;
            function b(d, g) {
                for (var j = d[0].length, i = d.length, h = g[0].length, f = [], c = 0; c < i; c++)
                    for (var k = f[c] = [], b = 0; b < h; b++) {
                        for (var e = 0, a = 0; a < j; a++)
                            e += d[c][a] * g[a][b];
                        k[b] = e
                    }
                return f
            }
            a.A = function (b, c) {
                return a.od(b, c, 0)
            };
            a.D = function (b, c) {
                return a.od(b, 0, c)
            };
            a.od = function (a, c, d) {
                return b(a, [[c, 0], [0, d]])
            };
            a.ib = function (d, c) {
                var a = b(d, [[c.x], [c.y]]);
                return u(a[0][0], a[1][0])
            }
        };
        var N = {kd: 0, ld: 0, C: 0, B: 0, z: 1, A: 1, D: 1, Q: 0, Z: 0, Y: 0, jb: 0, kb: 0, V: 0, Qb: 0, Nb: 0};
        h.sc = function (a) {
            var c = a || {};
            if (a)
                if (b.Fd(a))
                    c = {xc: c};
                else if (b.Fd(a.e))
                    c.e = {xc: a.e};
            return c
        };
        function pb(c, a) {
            var b = {};
            n(c, function (c, d) {
                var e = c;
                if (a[d] != l)
                    if (h.Jb(c))
                        e = c + a[d];
                    else
                        e = pb(c, a[d]);
                b[d] = e
            });
            return b
        }
        h.le = pb;
        h.pd = function (k, m, x, q, z, A, n) {
            var a = m;
            if (k) {
                a = {};
                for (var g in m) {
                    var B = A[g] || 1, w = z[g] || [0, 1], f = (x - w[0]) / w[1];
                    f = c.min(c.max(f, 0), 1);
                    f = f * B;
                    var u = c.floor(f);
                    if (f != u)
                        f -= u;
                    var h = q.xc || e.zc, i, C = k[g], o = m[g];
                    if (b.Jb(o)) {
                        h = q[g] || h;
                        var y = h(f);
                        i = C + o * y
                    } else {
                        i = b.p({Lb: {}}, k[g]);
                        var v = q[g] || {};
                        b.a(o.Lb || o, function (d, a) {
                            h = v[a] || v.xc || h;
                            var c = h(f), b = d * c;
                            i.Lb[a] = b;
                            i[a] += b
                        })
                    }
                    a[g] = i
                }
                var t = b.a(m, function (b, a) {
                    return N[a] != l
                });
                t && b.a(N, function (c, b) {
                    if (a[b] == l && k[b] !== l)
                        a[b] = k[b]
                });
                if (t) {
                    if (a.z)
                        a.A = a.D = a.z;
                    a.cb = n.cb;
                    a.mb = n.mb;
                    a.je = d
                }
            }
            if (m.e && n.gb) {
                var p = a.e.Lb, s = (p.g || 0) + (p.n || 0), r = (p.f || 0) + (p.o || 0);
                a.f = (a.f || 0) + r;
                a.g = (a.g || 0) + s;
                a.e.f -= r;
                a.e.o -= r;
                a.e.g -= s;
                a.e.n -= s
            }
            if (a.e && b.Ig() && !a.e.g && !a.e.f && !a.e.B && !a.e.C && a.e.o == n.cb && a.e.n == n.mb)
                a.e = j;
            return a
        }
    };
    function n() {
        var a = this, d = [];
        function i(a, b) {
            d.push({Bc: a, tc: b})
        }
        function h(a, c) {
            b.a(d, function (b, e) {
                b.Bc == a && b.tc === c && d.splice(e, 1)
            })
        }
        a.qb = a.addEventListener = i;
        a.removeEventListener = h;
        a.k = function (a) {
            var c = [].slice.call(arguments, 1);
            b.a(d, function (b) {
                b.Bc == a && b.tc.apply(f, c)
            })
        }
    }
    var m = function (z, C, i, J, M, L) {
        z = z || 0;
        var a = this, q, n, o, u, A = 0, G, H, F, B, y = 0, h = 0, m = 0, D, l, g, e, p, w = [], x;
        function O(a) {
            g += a;
            e += a;
            l += a;
            h += a;
            m += a;
            y += a
        }
        function t(o) {
            var f = o;
            if (p && (f >= e || f <= g))
                f = ((f - g) % p + p) % p + g;
            if (!D || u || h != f) {
                var j = c.min(f, e);
                j = c.max(j, g);
                if (!D || u || j != m) {
                    if (L) {
                        var k = (j - l) / (C || 1);
                        if (i.Ed)
                            k = 1 - k;
                        var n = b.pd(M, L, k, G, F, H, i);
                        if (x)
                            b.a(n, function (b, a) {
                                x[a] && x[a](J, b)
                            });
                        else
                            b.F(J, n)
                    }
                    a.uc(m - l, j - l);
                    m = j;
                    b.a(w, function (b, c) {
                        var a = o < h ? w[w.length - c - 1] : b;
                        a.u(m - y)
                    });
                    var r = h, q = m;
                    h = f;
                    D = d;
                    a.Ob(r, q)
                }
            }
        }
        function E(a, b, d) {
            b && a.sb(e);
            if (!d) {
                g = c.min(g, a.wc() + y);
                e = c.max(e, a.Rb() + y)
            }
            w.push(a)
        }
        var r = f.requestAnimationFrame || f.webkitRequestAnimationFrame || f.mozRequestAnimationFrame || f.msRequestAnimationFrame;
        if (b.gg() && b.Id() < 7)
            r = j;
        r = r || function (a) {
            b.Fb(a, i.fb)
        };
        function I() {
            if (q) {
                var d = b.U(), e = c.min(d - A, i.zd), a = h + e * o;
                A = d;
                if (a * o >= n * o)
                    a = n;
                t(a);
                if (!u && a * o >= n * o)
                    K(B);
                else
                    r(I)
            }
        }
        function s(f, i, j) {
            if (!q) {
                q = d;
                u = j;
                B = i;
                f = c.max(f, g);
                f = c.min(f, e);
                n = f;
                o = n < h ? -1 : 1;
                a.yd();
                A = b.U();
                r(I)
            }
        }
        function K(b) {
            if (q) {
                u = q = B = k;
                a.dd();
                b && b()
            }
        }
        a.fd = function (a, b, c) {
            s(a ? h + a : e, b, c)
        };
        a.ad = s;
        a.lb = K;
        a.ee = function (a) {
            s(a)
        };
        a.W = function () {
            return h
        };
        a.Kc = function () {
            return n
        };
        a.ub = function () {
            return m
        };
        a.u = t;
        a.gb = function (a) {
            t(h + a)
        };
        a.Ec = function () {
            return q
        };
        a.ne = function (a) {
            p = a
        };
        a.sb = O;
        a.Eb = function (a, b) {
            E(a, 0, b)
        };
        a.rc = function (a) {
            E(a, 1)
        };
        a.oe = function (a) {
            e += a
        };
        a.wc = function () {
            return g
        };
        a.Rb = function () {
            return e
        };
        a.Ob = a.yd = a.dd = a.uc = b.bd;
        a.nc = b.U();
        i = b.p({fb: 16, zd: 50}, i);
        p = i.Tc;
        x = i.De;
        g = l = z;
        e = z + C;
        H = i.Mc || {};
        F = i.Lc || {};
        G = b.sc(i.G)
    };
    var p = new function () {
        var h = this;
        function g(b, a, c) {
            c.push(a);
            b[a] = b[a] || [];
            b[a].push(c)
        }
        h.te = function (d) {
            for (var e = [], a, b = 0; b < d.hb; b++)
                for (a = 0; a < d.s; a++)
                    g(e, c.ceil(1e5 * c.random()) % 13, [b, a]);
            return e
        }
    }, s = function (l, s, q, u, z) {
        var f = this, v, g, a, y = 0, x = u.qe, r, h = 8;
        function t(a) {
            if (a.g)
                a.B = a.g;
            if (a.f)
                a.C = a.f;
            b.a(a, function (a) {
                b.Rc(a) && t(a)
            })
        }
        function i(g, f) {
            var a = {fb: f, jc: 1, Fb: 0, s: 1, hb: 1, L: 0, z: 0, e: 0, gb: k, Ac: k, Ed: k, Td: p.te, Pc: {Kd: 0, Od: 0}, G: e.zc, Mc: {}, Ib: [], Lc: {}};
            b.p(a, g);
            t(a);
            a.G = b.sc(a.G);
            a.Rd = c.ceil(a.jc / a.fb);
            a.Ld = function (c, b) {
                c /= a.s;
                b /= a.hb;
                var f = c + "x" + b;
                if (!a.Ib[f]) {
                    a.Ib[f] = {N: c, O: b};
                    for (var d = 0; d < a.s; d++)
                        for (var e = 0; e < a.hb; e++)
                            a.Ib[f][e + "," + d] = {g: e * b, o: d * c + c, n: e * b + b, f: d * c}
                }
                return a.Ib[f]
            };
            if (a.Cc) {
                a.Cc = i(a.Cc, f);
                a.Ac = d
            }
            return a
        }
        function o(B, h, a, w, o, m) {
            var z = this, u, v = {}, i = {}, n = [], f, e, s, q = a.Pc.Kd || 0, r = a.Pc.Od || 0, g = a.Ld(o, m), p = C(a), D = p.length - 1, t = a.jc + a.Fb * D, x = w + t, l = a.Ac, y;
            x += 50;
            function C(a) {
                var b = a.Td(a);
                return a.Ed ? b.reverse() : b
            }
            z.Gc = x;
            z.Hb = function (d) {
                d -= w;
                var e = d < t;
                if (e || y) {
                    y = e;
                    if (!l)
                        d = t - d;
                    var f = c.ceil(d / a.fb);
                    b.a(i, function (a, e) {
                        var d = c.max(f, a.Nd);
                        d = c.min(d, a.length - 1);
                        if (a.md != d) {
                            if (!a.md && !l)
                                b.E(n[e]);
                            else
                                d == a.Md && l && b.T(n[e]);
                            a.md = d;
                            b.F(n[e], a[d])
                        }
                    })
                }
            };
            h = b.ab(h);
            b.rb(h, j);
            if (b.nb()) {
                var E = !h["no-image"], A = b.lg(h);
                b.a(A, function (a) {
                    (E || a["jssor-slider"]) && b.Db(a, b.Db(a), d)
                })
            }
            b.a(p, function (h, j) {
                b.a(h, function (G) {
                    var K = G[0], J = G[1], t = K + "," + J, n = k, p = k, x = k;
                    if (q && J % 2) {
                        if (q & 3)
                            n = !n;
                        if (q & 12)
                            p = !p;
                        if (q & 16)
                            x = !x
                    }
                    if (r && K % 2) {
                        if (r & 3)
                            n = !n;
                        if (r & 12)
                            p = !p;
                        if (r & 16)
                            x = !x
                    }
                    a.g = a.g || a.e & 4;
                    a.n = a.n || a.e & 8;
                    a.f = a.f || a.e & 1;
                    a.o = a.o || a.e & 2;
                    var E = p ? a.n : a.g, B = p ? a.g : a.n, D = n ? a.o : a.f, C = n ? a.f : a.o;
                    a.e = E || B || D || C;
                    s = {};
                    e = {B: 0, C: 0, L: 1, N: o, O: m};
                    f = b.p({}, e);
                    u = b.p({}, g[t]);
                    if (a.L)
                        e.L = 2 - a.L;
                    if (a.S) {
                        e.S = a.S;
                        f.S = 0
                    }
                    var I = a.s * a.hb > 1 || a.e;
                    if (a.z || a.Q) {
                        var H = d;
                        if (b.nb())
                            if (a.s * a.hb > 1)
                                H = k;
                            else
                                I = k;
                        if (H) {
                            e.z = a.z ? a.z - 1 : 1;
                            f.z = 1;
                            if (b.nb() || b.xd())
                                e.z = c.min(e.z, 2);
                            var N = a.Q || 0;
                            e.Q = N * 360 * (x ? -1 : 1);
                            f.Q = 0
                        }
                    }
                    if (I) {
                        var h = u.Lb = {};
                        if (a.e) {
                            var w = a.Tg || 1;
                            if (E && B) {
                                h.g = g.O / 2 * w;
                                h.n = -h.g
                            } else if (E)
                                h.n = -g.O * w;
                            else if (B)
                                h.g = g.O * w;
                            if (D && C) {
                                h.f = g.N / 2 * w;
                                h.o = -h.f
                            } else if (D)
                                h.o = -g.N * w;
                            else if (C)
                                h.f = g.N * w
                        }
                        s.e = u;
                        f.e = g[t]
                    }
                    var L = n ? 1 : -1, M = p ? 1 : -1;
                    if (a.x)
                        e.C += o * a.x * L;
                    if (a.y)
                        e.B += m * a.y * M;
                    b.a(e, function (a, c) {
                        if (b.Jb(a))
                            if (a != f[c])
                                s[c] = a - f[c]
                    });
                    v[t] = l ? f : e;
                    var F = a.Rd, A = c.round(j * a.Fb / a.fb);
                    i[t] = new Array(A);
                    i[t].Nd = A;
                    i[t].Md = A + F - 1;
                    for (var z = 0; z <= F; z++) {
                        var y = b.pd(f, s, z / F, a.G, a.Lc, a.Mc, {gb: a.gb, cb: o, mb: m});
                        y.S = y.S || 1;
                        i[t].push(y)
                    }
                })
            });
            p.reverse();
            b.a(p, function (a) {
                b.a(a, function (c) {
                    var f = c[0], e = c[1], d = f + "," + e, a = h;
                    if (e || f)
                        a = b.ab(h);
                    b.F(a, v[d]);
                    b.Ab(a, "hidden");
                    b.r(a, "absolute");
                    B.pg(a);
                    n[d] = a;
                    b.E(a, !l)
                })
            })
        }
        function w() {
            var b = this, c = 0;
            m.call(b, 0, v);
            b.Ob = function (d, b) {
                if (b - c > h) {
                    c = b;
                    a && a.Hb(b);
                    g && g.Hb(b)
                }
            };
            b.ic = r
        }
        f.Pd = function () {
            var a = 0, b = u.eb, d = b.length;
            if (x)
                a = y++ % d;
            else
                a = c.floor(c.random() * d);
            b[a] && (b[a].ob = a);
            return b[a]
        };
        f.se = function (w, x, k, m, b) {
            r = b;
            b = i(b, h);
            var j = m.Qc, e = k.Qc;
            j["no-image"] = !m.vc;
            e["no-image"] = !k.vc;
            var n = j, p = e, u = b, d = b.Cc || i({}, h);
            if (!b.Ac) {
                n = e;
                p = j
            }
            var t = d.sb || 0;
            g = new o(l, p, d, c.max(t - d.fb, 0), s, q);
            a = new o(l, n, u, c.max(d.fb - t, 0), s, q);
            g.Hb(0);
            a.Hb(0);
            v = c.max(g.Gc, a.Gc);
            f.ob = w
        };
        f.wb = function () {
            l.wb();
            g = j;
            a = j
        };
        f.ue = function () {
            var b = j;
            if (a)
                b = new w;
            return b
        };
        if (b.nb() || b.xd() || z && b.ng() < 537)
            h = 16;
        n.call(f);
        m.call(f, -1e7, 1e7)
    }, i = function (p, fc) {
        var h = this;
        function Bc() {
            var a = this;
            m.call(a, -1e8, 2e8);
            a.ve = function () {
                var b = a.ub(), d = c.floor(b), f = t(d), e = b - c.floor(b);
                return{ob: f, we: d, tb: e}
            };
            a.Ob = function (b, a) {
                var e = c.floor(a);
                if (e != a && a > b)
                    e++;
                Tb(e, d);
                h.k(i.xe, t(a), t(b), a, b)
            }
        }
        function Ac() {
            var a = this;
            m.call(a, 0, 0, {Tc: r});
            b.a(C, function (b) {
                D & 1 && b.ne(r);
                a.rc(b);
                b.sb(kb / bc)
            })
        }
        function zc() {
            var a = this, b = Ub.db;
            m.call(a, -1, 2, {G: e.Dc, De: {tb: Zb}, Tc: r}, b, {tb: 1}, {tb: -2});
            a.qc = b
        }
        function mc(o, n) {
            var b = this, e, f, g, l, c;
            m.call(b, -1e8, 2e8, {zd: 100});
            b.yd = function () {
                M = d;
                R = j;
                h.k(i.ye, t(w.W()), w.W())
            };
            b.dd = function () {
                M = k;
                l = k;
                var a = w.ve();
                h.k(i.ze, t(w.W()), w.W());
                !a.tb && Dc(a.we, s)
            };
            b.Ob = function (i, h) {
                var b;
                if (l)
                    b = c;
                else {
                    b = f;
                    if (g) {
                        var d = h / g;
                        b = a.Be(d) * (f - e) + e
                    }
                }
                w.u(b)
            };
            b.Sb = function (a, d, c, h) {
                e = a;
                f = d;
                g = c;
                w.u(a);
                b.u(0);
                b.ad(c, h)
            };
            b.Ee = function (a) {
                l = d;
                c = a;
                b.fd(a, j, d)
            };
            b.pe = function (a) {
                c = a
            };
            w = new Bc;
            w.Eb(o);
            w.Eb(n)
        }
        function oc() {
            var c = this, a = Xb();
            b.v(a, 0);
            b.bb(a, "pointerEvents", "none");
            c.db = a;
            c.pg = function (c) {
                b.R(a, c);
                b.E(a)
            };
            c.wb = function () {
                b.T(a);
                b.bc(a)
            }
        }
        function xc(o, f) {
            var e = this, q, M, v, l, y = [], x, B, W, H, S, F, g, w, p;
            m.call(e, -u, u + 1, {});
            function E(a) {
                q && q.Ic();
                T(o, a, 0);
                F = d;
                q = new I.J(o, I, b.Vd(b.j(o, "idle")) || lc);
                q.u(0)
            }
            function Z() {
                q.nc < I.nc && E()
            }
            function O(p, r, o) {
                if (!H) {
                    H = d;
                    if (l && o) {
                        var g = o.width, c = o.height, n = g, m = c;
                        if (g && c && a.Bb) {
                            if (a.Bb & 3 && (!(a.Bb & 4) || g > K || c > J)) {
                                var j = k, q = K / J * c / g;
                                if (a.Bb & 1)
                                    j = q > 1;
                                else if (a.Bb & 2)
                                    j = q < 1;
                                n = j ? g * J / c : K;
                                m = j ? J : c * K / g
                            }
                            b.l(l, n);
                            b.m(l, m);
                            b.K(l, (J - m) / 2);
                            b.H(l, (K - n) / 2)
                        }
                        b.r(l, "absolute");
                        h.k(i.Yd, f)
                    }
                }
                b.T(r);
                p && p(e)
            }
            function Y(b, c, d, g) {
                if (g == R && s == f && N)
                    if (!Cc) {
                        var a = t(b);
                        A.se(a, f, c, e, d);
                        c.Zd();
                        U.sb(a - U.wc() - 1);
                        U.u(a);
                        z.Sb(b, b, 0)
                    }
            }
            function bb(b) {
                if (b == R && s == f) {
                    if (!g) {
                        var a = j;
                        if (A)
                            if (A.ob == f)
                                a = A.ue();
                            else
                                A.wb();
                        Z();
                        g = new vc(o, f, a, q);
                        g.Jd(p)
                    }
                    !g.Ec() && g.oc()
                }
            }
            function G(d, h, l) {
                if (d == f) {
                    if (d != h)
                        C[h] && C[h].vd();
                    else
                        !l && g && g.me();
                    p && p.Oc();
                    var m = R = b.U();
                    e.yb(b.P(j, bb, m))
                } else {
                    var k = c.min(f, d), i = c.max(f, d), o = c.min(i - k, k + r - i), n = u + a.ge - 1;
                    (!S || o <= n) && e.yb()
                }
            }
            function db() {
                if (s == f && g) {
                    g.lb();
                    p && p.ie();
                    p && p.ke();
                    g.nd()
                }
            }
            function eb() {
                s == f && g && g.lb()
            }
            function ab(a) {
                !P && h.k(i.Ge, f, a)
            }
            function Q() {
                p = w.pInstance;
                g && g.Jd(p)
            }
            e.yb = function (c, a) {
                a = a || v;
                if (y.length && !H) {
                    b.E(a);
                    if (!W) {
                        W = d;
                        h.k(i.be, f);
                        b.a(y, function (a) {
                            if (!b.q(a, "src")) {
                                a.src = b.j(a, "src2");
                                b.X(a, a["display-origin"])
                            }
                        })
                    }
                    b.Fe(y, l, b.P(j, O, c, a))
                } else
                    O(c, a)
            };
            e.ae = function () {
                var i = f;
                if (a.Cd < 0)
                    i -= r;
                var d = i + a.Cd * tc;
                if (D & 2)
                    d = t(d);
                if (!(D & 1) && !ib)
                    d = c.max(0, c.min(d, r - u));
                if (d != f) {
                    if (A) {
                        var g = A.Pd(r);
                        if (g) {
                            var k = R = b.U(), h = C[t(d)];
                            return h.yb(b.P(j, Y, d, h, g, k), v)
                        }
                    }
                    cb(d)
                } else if (a.Cb) {
                    e.vd();
                    G(f, f)
                }
            };
            e.Zb = function () {
                G(f, f, d)
            };
            e.vd = function () {
                p && p.ie();
                p && p.ke();
                e.Xc();
                g && g.Qd();
                g = j;
                E()
            };
            e.Zd = function () {
                b.T(o)
            };
            e.Xc = function () {
                b.E(o)
            };
            e.cf = function () {
                p && p.Oc()
            };
            function T(a, c, e) {
                if (b.q(a, "jssor-slider"))
                    return;
                if (!F) {
                    if (a.tagName == "IMG") {
                        y.push(a);
                        if (!b.q(a, "src")) {
                            S = d;
                            a["display-origin"] = b.X(a);
                            b.T(a)
                        }
                    }
                    b.nb() && b.v(a, (b.v(a) || 0) + 1)
                }
                var f = b.xb(a);
                b.a(f, function (f) {
                    var h = f.tagName, i = b.j(f, "u");
                    if (i == "player" && !w) {
                        w = f;
                        if (w.pInstance)
                            Q();
                        else
                            b.c(w, "dataavailable", Q)
                    }
                    if (i == "caption") {
                        if (c) {
                            b.Hc(f, b.j(f, "to"));
                            b.sg(f, b.j(f, "bf"));
                            b.j(f, "3d") && b.tg(f, "preserve-3d")
                        } else if (!b.wd()) {
                            var g = b.ab(f, k, d);
                            b.Mb(g, f, a);
                            b.Gb(f, a);
                            f = g;
                            c = d
                        }
                    } else if (!F && !e && !l) {
                        if (h == "A") {
                            if (b.j(f, "u") == "image")
                                l = b.He(f, "IMG");
                            else
                                l = b.I(f, "image", d);
                            if (l) {
                                x = f;
                                b.X(x, "block");
                                b.F(x, V);
                                B = b.ab(x, d);
                                b.r(x, "relative");
                                b.Db(B, 0);
                                b.bb(B, "backgroundColor", "#000")
                            }
                        } else if (h == "IMG" && b.j(f, "u") == "image")
                            l = f;
                        if (l) {
                            l.border = 0;
                            b.F(l, V)
                        }
                    }
                    T(f, c, e + 1)
                })
            }
            e.uc = function (c, b) {
                var a = u - b;
                Zb(M, a)
            };
            e.ob = f;
            n.call(e);
            b.ug(o, b.j(o, "p"));
            b.vg(o, b.j(o, "po"));
            var L = b.I(o, "thumb", d);
            if (L) {
                b.ab(L);
                b.T(L)
            }
            b.E(o);
            v = b.ab(gb);
            b.v(v, 1e3);
            b.c(o, "click", ab);
            E(d);
            e.vc = l;
            e.Hd = B;
            e.Qc = o;
            e.qc = M = o;
            b.R(M, v);
            h.qb(203, G);
            h.qb(28, eb);
            h.qb(24, db)
        }
        function vc(y, f, p, q) {
            var a = this, n = 0, u = 0, g, j, e, c, l, t, r, o = C[f];
            m.call(a, 0, 0);
            function v() {
                b.bc(L);
                cc && l && o.Hd && b.R(L, o.Hd);
                b.E(L, !l && o.vc)
            }
            function w() {
                a.oc()
            }
            function x(b) {
                r = b;
                a.lb();
                a.oc()
            }
            a.oc = function () {
                var b = a.ub();
                if (!B && !M && !r && s == f) {
                    if (!b) {
                        if (g && !l) {
                            l = d;
                            a.nd(d);
                            h.k(i.Lg, f, n, u, g, c)
                        }
                        v()
                    }
                    var k, p = i.Fc;
                    if (b != c)
                        if (b == e)
                            k = c;
                        else if (b == j)
                            k = e;
                        else if (!b)
                            k = j;
                        else
                            k = a.Kc();
                    h.k(p, f, b, n, j, e, c);
                    var m = N && (!E || F);
                    if (b == c)
                        (e != c && !(E & 12) || m) && o.ae();
                    else
                        (m || b != e) && a.ad(k, w)
                }
            };
            a.me = function () {
                e == c && e == a.ub() && a.u(j)
            };
            a.Qd = function () {
                A && A.ob == f && A.wb();
                var b = a.ub();
                b < c && h.k(i.Fc, f, -b - 1, n, j, e, c)
            };
            a.nd = function (a) {
                p && b.Ab(lb, a && p.ic.Pg ? "" : "hidden")
            };
            a.uc = function (b, a) {
                if (l && a >= g) {
                    l = k;
                    v();
                    o.Xc();
                    A.wb();
                    h.k(i.Mg, f, n, u, g, c)
                }
                h.k(i.dg, f, a, n, j, e, c)
            };
            a.Jd = function (a) {
                if (a && !t) {
                    t = a;
                    a.qb($JssorPlayer$.Ae, x)
                }
            };
            p && a.rc(p);
            g = a.Rb();
            a.rc(q);
            j = g + q.Zc;
            e = g + q.Uc;
            c = a.Rb()
        }
        function Kb(a, c, d) {
            b.H(a, c);
            b.K(a, d)
        }
        function Zb(c, b) {
            var a = x > 0 ? x : fb, d = zb * b * (a & 1), e = Ab * b * (a >> 1 & 1);
            Kb(c, d, e)
        }
        function Pb() {
            qb = M;
            Ib = z.Kc();
            G = w.W()
        }
        function gc() {
            Pb();
            if (B || !F && E & 12) {
                z.lb();
                h.k(i.fg)
            }
        }
        function ec(f) {
            if (!B && (F || !(E & 12)) && !z.Ec()) {
                var d = w.W(), b = c.ceil(G);
                if (f && c.abs(H) >= a.Nc) {
                    b = c.ceil(d);
                    b += jb
                }
                if (!(D & 1))
                    b = c.min(r - u, c.max(b, 0));
                var e = c.abs(b - d);
                e = 1 - c.pow(1 - e, 5);
                if (!P && qb)
                    z.ee(Ib);
                else if (d == b) {
                    tb.cf();
                    tb.Zb()
                } else
                    z.Sb(d, b, e * Vb)
            }
        }
        function Hb(a) {
            !b.j(b.cc(a), "nodrag") && b.Ub(a)
        }
        function rc(a) {
            Yb(a, 1)
        }
        function Yb(a, c) {
            a = b.Bd(a);
            var l = b.cc(a);
            if (!O && !b.j(l, "nodrag") && sc() && (!c || a.touches.length == 1)) {
                B = d;
                yb = k;
                R = j;
                b.c(g, c ? "touchmove" : "mousemove", Bb);
                b.U();
                P = 0;
                gc();
                if (!qb)
                    x = 0;
                if (c) {
                    var f = a.touches[0];
                    ub = f.clientX;
                    vb = f.clientY
                } else {
                    var e = b.ed(a);
                    ub = e.x;
                    vb = e.y
                }
                H = 0;
                hb = 0;
                jb = 0;
                h.k(i.hg, t(G), G, a)
            }
        }
        function Bb(e) {
            if (B) {
                e = b.Bd(e);
                var f;
                if (e.type != "mousemove") {
                    var l = e.touches[0];
                    f = {x: l.clientX, y: l.clientY}
                } else
                    f = b.ed(e);
                if (f) {
                    var j = f.x - ub, k = f.y - vb;
                    if (c.floor(G) != G)
                        x = x || fb & O;
                    if ((j || k) && !x) {
                        if (O == 3)
                            if (c.abs(k) > c.abs(j))
                                x = 2;
                            else
                                x = 1;
                        else
                            x = O;
                        if (ob && x == 1 && c.abs(k) - c.abs(j) > 3)
                            yb = d
                    }
                    if (x) {
                        var a = k, i = Ab;
                        if (x == 1) {
                            a = j;
                            i = zb
                        }
                        if (!(D & 1)) {
                            if (a > 0) {
                                var g = i * s, h = a - g;
                                if (h > 0)
                                    a = g + c.sqrt(h) * 5
                            }
                            if (a < 0) {
                                var g = i * (r - u - s), h = -a - g;
                                if (h > 0)
                                    a = -g - c.sqrt(h) * 5
                            }
                        }
                        if (H - hb < -2)
                            jb = 0;
                        else if (H - hb > 2)
                            jb = -1;
                        hb = H;
                        H = a;
                        sb = G - H / i / (Y || 1);
                        if (H && x && !yb) {
                            b.Ub(e);
                            if (!M)
                                z.Ee(sb);
                            else
                                z.pe(sb)
                        }
                    }
                }
            }
        }
        function bb() {
            qc();
            if (B) {
                B = k;
                b.U();
                b.M(g, "mousemove", Bb);
                b.M(g, "touchmove", Bb);
                P = H;
                z.lb();
                var a = w.W();
                h.k(i.ig, t(a), a, t(G), G);
                E & 12 && Pb();
                ec(d)
            }
        }
        function jc(c) {
            if (P) {
                b.mg(c);
                var a = b.cc(c);
                while (a && v !== a) {
                    a.tagName == "A" && b.Ub(c);
                    try {
                        a = a.parentNode
                    } catch (d) {
                        break
                    }
                }
            }
        }
        function Jb(a) {
            C[s];
            s = t(a);
            tb = C[s];
            Tb(a);
            return s
        }
        function Dc(a, b) {
            x = 0;
            Jb(a);
            h.k(i.qg, t(a), b)
        }
        function Tb(a, c) {
            wb = a;
            b.a(S, function (b) {
                b.ec(t(a), a, c)
            })
        }
        function sc() {
            var b = i.Sc || 0, a = X;
            if (ob)
                a & 1 && (a &= 1);
            i.Sc |= a;
            return O = a & ~b
        }
        function qc() {
            if (O) {
                i.Sc &= ~X;
                O = 0
            }
        }
        function Xb() {
            var a = b.Tb();
            b.F(a, V);
            b.r(a, "absolute");
            return a
        }
        function t(a) {
            return(a % r + r) % r
        }
        function kc(b, d) {
            if (d)
                if (!D) {
                    b = c.min(c.max(b + wb, 0), r - u);
                    d = k
                } else if (D & 2) {
                    b = t(b + wb);
                    d = k
                }
            cb(b, a.fc, d)
        }
        function xb() {
            b.a(S, function (a) {
                a.Vb(a.Pb.Og <= F)
            })
        }
        function hc() {
            if (!F) {
                F = 1;
                xb();
                if (!B) {
                    E & 12 && ec();
                    E & 3 && C[s].Zb()
                }
            }
        }
        function Ec() {
            if (F) {
                F = 0;
                xb();
                B || !(E & 12) || gc()
            }
        }
        function ic() {
            V = {N: K, O: J, g: 0, f: 0};
            b.a(T, function (a) {
                b.F(a, V);
                b.r(a, "absolute");
                b.Ab(a, "hidden");
                b.T(a)
            });
            b.F(gb, V)
        }
        function ab(b, a) {
            cb(b, a, d)
        }
        function cb(g, f, j) {
            if (Rb && (!B && (F || !(E & 12)) || a.Vc)) {
                M = d;
                B = k;
                z.lb();
                if (f == l)
                    f = Vb;
                var e = Cb.ub(), b = g;
                if (j) {
                    b = e + g;
                    if (g > 0)
                        b = c.ceil(b);
                    else
                        b = c.floor(b)
                }
                if (D & 2)
                    b = t(b);
                if (!(D & 1))
                    b = c.max(0, c.min(b, r - u));
                var i = (b - e) % r;
                b = e + i;
                var h = e == b ? 0 : f * c.abs(i);
                h = c.min(h, f * u * 1.5);
                z.Sb(e, b, h || 1)
            }
        }
        h.fd = function () {
            if (!N) {
                N = d;
                C[s] && C[s].Zb()
            }
        };
        function W() {
            return b.l(y || p)
        }
        function nb() {
            return b.m(y || p)
        }
        h.cb = W;
        h.mb = nb;
        function Eb(c, d) {
            if (c == l)
                return b.l(p);
            if (!y) {
                var a = b.Tb(g);
                b.Yc(a, b.Yc(p));
                b.Kb(a, b.Kb(p));
                b.X(a, "block");
                b.r(a, "relative");
                b.K(a, 0);
                b.H(a, 0);
                b.Ab(a, "visible");
                y = b.Tb(g);
                b.r(y, "absolute");
                b.K(y, 0);
                b.H(y, 0);
                b.l(y, b.l(p));
                b.m(y, b.m(p));
                b.Hc(y, "0 0");
                b.R(y, a);
                var h = b.xb(p);
                b.R(p, y);
                b.bb(p, "backgroundImage", "");
                b.a(h, function (c) {
                    b.R(b.j(c, "noscale") ? p : a, c);
                    b.j(c, "autocenter") && Lb.push(c)
                })
            }
            Y = c / (d ? b.m : b.l)(y);
            b.wg(y, Y);
            var f = d ? Y * W() : c, e = d ? c : Y * nb();
            b.l(p, f);
            b.m(p, e);
            b.a(Lb, function (a) {
                var c = b.ac(b.j(a, "autocenter"));
                b.Sd(a, c)
            })
        }
        h.Jg = Eb;
        n.call(h);
        h.db = p = b.pb(p);
        var a = b.p({Bb: 0, ge: 1, Xb: 1, Wb: 0, Yb: k, Cb: 1, vb: d, Vc: d, Cd: 1, rd: 3e3, sd: 1, fc: 500, Be: e.Jc, Nc: 20, td: 0, s: 1, cd: 0, Gg: 1, yc: 1, qd: 1}, fc);
        a.vb = a.vb && b.jg();
        if (a.Fg != l)
            a.rd = a.Fg;
        if (a.Hg != l)
            a.cd = a.Hg;
        var fb = a.yc & 3, tc = (a.yc & 4) / -4 || 1, mb = a.xg, I = b.p({J: q, vb: a.vb}, a.Dg);
        I.eb = I.eb || I.Rg;
        var Fb = a.Cg, Z = a.Bg, eb = a.Qg, Q = !a.Gg, y, v = b.I(p, "slides", Q), gb = b.I(p, "loading", Q) || b.Tb(g), Nb = b.I(p, "navigator", Q), dc = b.I(p, "arrowleft", Q), ac = b.I(p, "arrowright", Q), Mb = b.I(p, "thumbnavigator", Q), pc = b.l(v), nc = b.m(v), V, T = [], uc = b.xb(v);
        b.a(uc, function (a) {
            if (a.tagName == "DIV" && !b.j(a, "u"))
                T.push(a);
            else
                b.nb() && b.v(a, (b.v(a) || 0) + 1)
        });
        var s = -1, wb, tb, r = T.length, K = a.Ag || pc, J = a.cg || nc, Wb = a.td, zb = K + Wb, Ab = J + Wb, bc = fb & 1 ? zb : Ab, u = c.min(a.s, r), lb, x, O, yb, S = [], Qb, Sb, Ob, cc, Cc, N, E = a.sd, lc = a.rd, Vb = a.fc, rb, ib, kb, Rb = u < r, D = Rb ? a.Cb : 0, X, P, F = 1, M, B, R, ub = 0, vb = 0, H, hb, jb, Cb, w, U, z, Ub = new oc, Y, Lb = [];
        if (r) {
            if (a.vb)
                Kb = function (a, c, d) {
                    b.rb(a, {jb: c, kb: d})
                };
            N = a.Yb;
            h.Pb = fc;
            ic();
            b.q(p, "jssor-slider", d);
            b.v(v, b.v(v) || 0);
            b.r(v, "absolute");
            lb = b.ab(v, d);
            b.Mb(lb, v);
            if (mb) {
                cc = mb.Sg;
                rb = mb.J;
                ib = u == 1 && r > 1 && rb && (!b.wd() || b.Id() >= 8)
            }
            kb = ib || u >= r || !(D & 1) ? 0 : a.cd;
            X = (u > 1 || kb ? fb : -1) & a.qd;
            var Gb = v, C = [], A, L, Db = b.yg(), ob = Db.Eg, G, qb, Ib, sb;
            Db.hd && b.bb(Gb, Db.hd, ([j, "pan-y", "pan-x", "none"])[X] || "");
            U = new zc;
            if (ib)
                A = new rb(Ub, K, J, mb, ob);
            b.R(lb, U.qc);
            b.Ab(v, "hidden");
            L = Xb();
            b.bb(L, "backgroundColor", "#000");
            b.Db(L, 0);
            b.Mb(L, Gb.firstChild, Gb);
            for (var db = 0; db < T.length; db++) {
                var wc = T[db], yc = new xc(wc, db);
                C.push(yc)
            }
            b.T(gb);
            Cb = new Ac;
            z = new mc(Cb, U);
            b.c(v, "click", jc, d);
            b.c(p, "mouseout", b.hc(hc, p));
            b.c(p, "mouseover", b.hc(Ec, p));
            if (X) {
                b.c(v, "mousedown", Yb);
                b.c(v, "touchstart", rc);
                b.c(v, "dragstart", Hb);
                b.c(v, "selectstart", Hb);
                b.c(g, "mouseup", bb);
                b.c(g, "touchend", bb);
                b.c(g, "touchcancel", bb);
                b.c(f, "blur", bb)
            }
            E &= ob ? 10 : 5;
            if (Nb && Fb) {
                Qb = new Fb.J(Nb, Fb, W(), nb());
                S.push(Qb)
            }
            if (Z && dc && ac) {
                Z.Cb = D;
                Z.s = u;
                Sb = new Z.J(dc, ac, Z, W(), nb());
                S.push(Sb)
            }
            if (Mb && eb) {
                eb.Wb = a.Wb;
                Ob = new eb.J(Mb, eb);
                S.push(Ob)
            }
            b.a(S, function (a) {
                a.kc(r, C, gb);
                a.qb(o.lc, kc)
            });
            b.bb(p, "visibility", "visible");
            Eb(W());
            xb();
            a.Xb && b.c(g, "keydown", function (b) {
                if (b.keyCode == 37)
                    ab(-a.Xb);
                else
                    b.keyCode == 39 && ab(a.Xb)
            });
            var pb = a.Wb;
            if (!(D & 1))
                pb = c.max(0, c.min(pb, r - u));
            z.Sb(pb, pb, 0)
        }
    };
    i.Ge = 21;
    i.hg = 22;
    i.ig = 23;
    i.ye = 24;
    i.ze = 25;
    i.be = 26;
    i.Yd = 27;
    i.fg = 28;
    i.xe = 202;
    i.qg = 203;
    i.Lg = 206;
    i.Mg = 207;
    i.dg = 208;
    i.Fc = 209;
    var o = {lc: 1}, r = function (e, C) {
        var f = this;
        n.call(f);
        e = b.pb(e);
        var s, A, z, r, l = 0, a, m, i, w, x, h, g, q, p, B = [], y = [];
        function v(a) {
            a != -1 && y[a].re(a == l)
        }
        function t(a) {
            f.k(o.lc, a * m)
        }
        f.db = e;
        f.ec = function (a) {
            if (a != r) {
                var d = l, b = c.floor(a / m);
                l = b;
                r = a;
                v(d);
                v(b)
            }
        };
        f.Vb = function (a) {
            b.E(e, a)
        };
        var u;
        f.kc = function (D) {
            if (!u) {
                s = c.ceil(D / m);
                l = 0;
                var o = q + w, r = p + x, n = c.ceil(s / i) - 1;
                A = q + o * (!h ? n : i - 1);
                z = p + r * (h ? n : i - 1);
                b.l(e, A);
                b.m(e, z);
                for (var f = 0; f < s; f++) {
                    var C = b.eg();
                    b.rg(C, f + 1);
                    var k = b.Xd(g, "numbertemplate", C, d);
                    b.r(k, "absolute");
                    var v = f % (n + 1);
                    b.H(k, !h ? o * v : f % i * o);
                    b.K(k, h ? r * v : c.floor(f / (n + 1)) * r);
                    b.R(e, k);
                    B[f] = k;
                    a.mc & 1 && b.c(k, "click", b.P(j, t, f));
                    a.mc & 2 && b.c(k, "mouseover", b.hc(b.P(j, t, f), k));
                    y[f] = b.gc(k)
                }
                u = d
            }
        };
        f.Pb = a = b.p({ud: 10, gd: 10, id: 1, mc: 1}, C);
        g = b.I(e, "prototype");
        q = b.l(g);
        p = b.m(g);
        b.Gb(g, e);
        m = a.jd || 1;
        i = a.hb || 1;
        w = a.ud;
        x = a.gd;
        h = a.id - 1;
        a.dc == k && b.q(e, "noscale", d);
        a.zb && b.q(e, "autocenter", a.zb)
    }, t = function (a, g, h) {
        var c = this;
        n.call(c);
        var r, q, e, f, i;
        b.l(a);
        b.m(a);
        function l(a) {
            c.k(o.lc, a, d)
        }
        function p(c) {
            b.E(a, c || !h.Cb && e == 0);
            b.E(g, c || !h.Cb && e >= q - h.s);
            r = c
        }
        c.ec = function (b, a, c) {
            if (c)
                e = a;
            else {
                e = b;
                p(r)
            }
        };
        c.Vb = p;
        var m;
        c.kc = function (c) {
            q = c;
            e = 0;
            if (!m) {
                b.c(a, "click", b.P(j, l, -i));
                b.c(g, "click", b.P(j, l, i));
                b.gc(a);
                b.gc(g);
                m = d
            }
        };
        c.Pb = f = b.p({jd: 1}, h);
        i = f.jd;
        if (f.dc == k) {
            b.q(a, "noscale", d);
            b.q(g, "noscale", d)
        }
        if (f.zb) {
            b.q(a, "autocenter", f.zb);
            b.q(g, "autocenter", f.zb)
        }
    };
    function q(e, d, c) {
        var a = this;
        m.call(a, 0, c);
        a.Ic = b.bd;
        a.Zc = 0;
        a.Uc = c
    }
    var u = function (n, f, l) {
        var a = this, o, g = {}, i = f.eb, c = new m(0, 0);
        m.call(a, 0, 0);
        function j(d, c) {
            var a = {};
            b.a(d, function (d, f) {
                var e = g[f];
                if (e) {
                    if (b.Rc(d))
                        d = j(d, c || f == "e");
                    else if (c)
                        if (b.Jb(d))
                            d = o[d];
                    a[e] = d
                }
            });
            return a
        }
        function k(e, c) {
            var a = [], d = b.xb(e);
            b.a(d, function (d) {
                var h = b.j(d, "u") == "caption";
                if (h) {
                    var e = b.j(d, "t"), g = i[b.ac(e)] || i[e], f = {db: d, ic: g};
                    a.push(f)
                }
                if (c < 5)
                    a = a.concat(k(d, c + 1))
            });
            return a
        }
        function r(e, f, a) {
            b.a(f, function (h) {
                var f = b.p(d, {}, j(h)), g = b.sc(f.G);
                delete f.G;
                if (f.f) {
                    f.C = f.f;
                    g.C = g.f;
                    delete f.f
                }
                if (f.g) {
                    f.B = f.g;
                    g.B = g.g;
                    delete f.g
                }
                var k = {G: g, cb: a.N, mb: a.O}, i = new m(h.b, h.d, k, e, a, f);
                c.Eb(i);
                a = b.le(a, f)
            });
            return a
        }
        function q(a) {
            b.a(a, function (d) {
                var a = d.db, f = b.l(a), e = b.m(a), c = {f: b.H(a), g: b.K(a), C: 0, B: 0, L: 1, S: b.v(a) || 0, Q: 0, Z: 0, Y: 0, A: 1, D: 1, jb: 0, kb: 0, V: 0, Qb: 0, Nb: 0, N: f, O: e, e: {g: 0, o: f, n: e, f: 0}};
                c.kd = c.f;
                c.ld = c.g;
                r(a, d.ic, c)
            })
        }
        function t(g, f, h) {
            var e = g.b - f;
            if (e) {
                var b = new m(f, e);
                b.Eb(c, d);
                b.sb(h);
                a.Eb(b)
            }
            a.oe(g.d);
            return e
        }
        function s(f) {
            var d = c.wc(), e = 0;
            b.a(f, function (c, f) {
                c = b.p({d: l}, c);
                t(c, d, e);
                d = c.b;
                e += c.d;
                if (!f || c.t == 2) {
                    a.Zc = d;
                    a.Uc = d + c.d
                }
            })
        }
        a.Ic = function () {
            a.u(-1, d)
        };
        o = [h.sf, h.rf, h.qf, h.gf, h.Je, h.Ke, h.Le, h.Me, h.Ne, h.Oe, h.Pe, h.Qe, h.Re, h.Se, h.Te, h.Ue, h.Ve, h.We, h.Xe, h.Ye, h.Ze, h.of, h.nf, h.mf, h.lf, h.kf, h.jf, h.pf, h.hf, h.ff, h.ef, h.df, h.bg, h.bf, h.af, h.If, h.ag];
        var u = {g: "y", f: "x", n: "m", o: "t", Q: "r", Z: "rX", Y: "rY", A: "sX", D: "sY", jb: "tX", kb: "tY", V: "tZ", Qb: "kX", Nb: "kY", L: "o", G: "e", S: "i", e: "c"};
        b.a(u, function (b, a) {
            g[b] = a
        });
        q(k(n, 1));
        c.u(-1);
        var p = f.Wg || [], e = [].concat(p[b.ac(b.j(n, "b"))] || []);
        e.push({b: c.Rb(), d: e.length ? 0 : l});
        s(e);
        a.u(-1)
    };
    jssor_1_slider_init = function () {
        var g = [{jc: 1200, L: 2}], h = [[{b: 0, d: 1160, x: 783, y: 3}], [{b: 260, d: 780, x: -869, y: 18}], [{b: 1160, d: 840, x: 667, y: 2}], [{b: 2020, d: 760, x: -11, y: -315}], [{b: 2780, d: 520, x: -272, y: -6}], [{b: 3300, d: 640, x: -3, y: -145}], [{b: 0, d: 700, x: 307, y: -1, i: 2}], [{b: 0, d: 700, x: -851, y: -5, i: 1}], [{b: 700, d: 800, x: -827, y: -11}], [{b: 1500, d: 500, x: -10, y: -114}], [{b: 2e3, d: 500, x: -9, y: 141}], [{b: 2e3, d: 420, x: 14, y: -158}], [{b: 2500, d: 1100, x: -281}], [{b: 0, d: 800, x: -870, y: 3}], [{b: 800, d: 500, x: 7, y: 112}], [{b: 800, d: 500, x: 103, y: -202}], [{b: 1300, d: 900, x: 12, y: -264}], [{b: 2200, d: 1e3, x: -450, y: 5}]], j = {Yb: d, xg: {J: s, eb: g, qe: 1}, Dg: {J: u, eb: h}, Bg: {J: t}, Cg: {J: r}}, e = new i("jssor_1", j);
        function a() {
            var b = e.db.parentNode.clientWidth;
            if (b) {
                b = c.min(b, 870);
                e.Jg(b)
            } else
                f.setTimeout(a, 30)
        }
        a();
        b.c(f, "load", a);
        b.c(f, "resize", a);
        b.c(f, "orientationchange", a)
    }
})(window, document, Math, null, true, false)
