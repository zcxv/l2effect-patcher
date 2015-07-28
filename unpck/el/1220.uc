class 1220 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect36
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.el_flame_strike_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect37
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		EffectClass=Class'LineageEffect.el_flame_strike_pr'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect41
		offset=(X=0.000000,Y=0.000000,Z=1.000000)
		EffectClass=Class'LineageEffect.el_flame_strike_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect38
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
	End Object
	Desc="블레이즈" //Blaze
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect36',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect37',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect41',SpecificStage=0)
	ExplosionActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect38',SpecificStage=0)
	FlyingTime=0.400000
}