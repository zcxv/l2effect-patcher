class 5023 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect22
		AttachOn=AM_LA
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.ph_howl_ta'
	End Object
	Desc="홀드" //Hold
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect22',SpecificStage=0)
}